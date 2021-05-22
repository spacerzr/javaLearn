import java.util.ArrayList;
import java.util.List;

/**
 * Коробка
 * @param <T> Тип содержимого коробки ( наследники Fruit )
 */
public class Box<T extends Fruit> {

    /**
     * внутренняя коллекция для сохранения элементов
     */
    private final List<T> list = new ArrayList<>();

    /**
     * Метод добавления элемента в коробку
     * @param element элемент класса, наследованного от Fruit
     */
    public void add(T element) {
        list.add(element);
    }

    /**
     * Метод считает вес коробки
     * @return вес коробки
     */
    public float getWeight() {
        float sum = 0;
        for (T element: list) {
            sum += element.getWeight();
        }
        return sum;
    }

    /**
     * Метод сравнения веса коробок
     * @param box другая коробка
     * @return true если вес коробок равен, иначе false
     */
    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    /**
     * Метод перекладывания содержимого текущей коробки в другую
     * @param box другая коробка, в которую перекладываются элементы
     */
    public void shift(Box<T> box) {
        box.list.addAll(list);
        list.clear();
    }
}
