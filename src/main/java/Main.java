import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        // создали объект для обработки
        CsvHandler handler = new CsvHandler();

        //создали заголовок
        String[] header = new String[]{"One", "Two", "Three", "Four"};

        //создали массив для данных и заполнили его случайными числами
        int[][] data = new int[10][];
        Random random = new Random();

        for (int j = 0; j< data.length; j++) {
            data[j] = new int[4];
            for (int i =0; i < data[j].length; i++) {
                data[j][i] = random.nextInt();
            }
        }

        //создали объект AppData
        AppData toWrite = new AppData(header, data);

        //путь куда будем записывать
        String path = "C:\\Users\\space\\Desktop\\javaLearn\\my-file.csv";
        //записываем сформированный объект в файл. Если успешно записали - читаем его же и печатаем в консоль
        if(handler.write(toWrite, path)) {
            System.out.println("Файл успешно записан");
            AppData result = handler.read(path);

            if(result != null) {
                System.out.println("Прочитан CSV файл:");
                System.out.println(result);
            } else {
                System.out.println("Файла нет. Путь указан неверно.");
            }
        } else {
            System.out.println("Файл не записан");
        }
    }
}