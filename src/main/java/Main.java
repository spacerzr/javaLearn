import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {

        CsvHandler handler = new CsvHandler();

        AppData result = handler.read("C:\\Users\\space\\Desktop\\javaLearn\\my.csv");

        if(result != null) {
            System.out.println("Прочитан CSV файл:");
            System.out.println(result);
        } else {
            System.out.println("Файла нет. Путь указан неверно.");
        }

        String[] header = new String[]{"One", "Two", "Three", "Four"};

        int[][] data = new int[10][];
        Random random = new Random();

        for (int j = 0; j< data.length; j++) {
            data[j] = new int[4];
            for (int i =0; i < data[j].length; i++) {
                data[j][i] = random.nextInt();
            }
        }

        AppData toWrite = new AppData(header, data);


        if(handler.write(toWrite, "C:\\Users\\space\\Desktop\\javaLearn\\second.csv")) {
            System.out.println("Файл успешно записан");
        } else {
            System.out.println("Файл не записан");
        }

    }
}