import java.util.Arrays;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    @Override
    public String toString() {
        String strData = "";
        for (int[] line : data) {
            strData += Arrays.toString(line) + "\n";
        }
        return Arrays.toString(header) + "\n" + strData;
    }
}
