import java.util.Arrays;

public class HoweWork {
    public static void main(String[] args) {
        changeArrayElementsVar1();
//        changeArrayElementsVar2();
        fillArray();
        multiplyNumbersOfSix();
        fillDiagonals();

        int[] result = initializeArray(8, 7);
        System.out.println(Arrays.toString(result));
    }

    // задание №1 вариант №1
    public static void changeArrayElementsVar1() {
        int[] array = {1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0};

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    // задание №1 вариант №2
    public static void changeArrayElementsVar2() {
        int[] array = new int[5];
        array[2] = 1;
        array[4] = 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //задание №2
    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    //задание №3
    public static void multiplyNumbersOfSix() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
//                array[i] = array[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //задание №4
    public static void fillDiagonals() {
        int[][] array = new int[9][9];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
            }

            for (int j = array[i].length - 1; j >= 0; j--) {
                if (i + j == array.length - 1) {
                    array[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    //задание №5
    public static int[] initializeArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
