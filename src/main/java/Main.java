import api.YandexApi;
import exception.YandexApiException;
import model.Weather;
import repository.DataBaseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("org.sqlite.JDBC");
        DataBaseRepository repository = new DataBaseRepository();
        repository.initializeTables();

        YandexApi yandexApi = new YandexApi();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Введите команду: 'загрузить', 'показать', 'очистить', 'завершить'");
            // ждем команду от пользователя
            String userRequest = reader.readLine();

            switch (userRequest) {
                case "загрузить": {
                    try {
                        List<Weather> weathers = yandexApi.getWeather();
                        repository.saveWeather(weathers);
                    }catch (YandexApiException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case "показать": {
                    List<Weather> weatherFromDb = repository.getWeatherFromDb();
                    if (weatherFromDb != null) {
                        if (weatherFromDb.size() == 0) {
                            System.out.println("Записей нет");
                        } else {
                            for (Weather weather : weatherFromDb) {
                                System.out.println(weather);
                            }
                        }
                    }
                    break;
                }

                case "очистить": {
                    repository.cleanDb();
                    System.out.println("Таблица погоды очищена");
                    break;
                }
                case "завершить": {
                    isRunning = false;
                    break;
                }
                default: {
                    System.out.println("такой команды нет");
                }
            }
        }


        System.out.println("Программа завершена");
    }
}
