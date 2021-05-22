import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"First", "Second", "Third"};
        changeArrayElements(array, 1, 2);
        System.out.println(Arrays.toString(array));

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();

        Box<Apple> appleBox = new Box<>();

        appleBox.add(apple1);
        appleBox.add(apple2);
        appleBox.add(apple3);
        appleBox.add(apple4);
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        Box<Orange> orangeBox = new Box<>();

        orangeBox.add(orange1);
        orangeBox.add(orange2);
        orangeBox.add(orange3);
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());

        System.out.println("Результат сравнения весов коробок: " + appleBox.compare(orangeBox));

        Box<Apple> appleBoxShifted = new Box<>();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        appleBoxShifted.add(apple5);
        appleBoxShifted.add(apple6);

        System.out.println("Вес новой коробки с яблоками: " + appleBoxShifted.getWeight());

        appleBox.shift(appleBoxShifted);

        System.out.println("==================================================================");
        System.out.println("Вес первой коробки после пересыпания: " + appleBox.getWeight());
        System.out.println("Вес новой коробки после пересыпания: " + appleBoxShifted.getWeight());

    }


    /**
     * Задание номер 1
     *
     * @param array       массив в котором будут заменены элементы
     * @param firstIndex  индекс первого элемента
     * @param secondIndex индекс второго элемента
     */
    public static void changeArrayElements(Object[] array, int firstIndex, int secondIndex) {
        Object temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
