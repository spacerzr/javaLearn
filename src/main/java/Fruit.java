/**
 * Родительский класс Фрукт
 */
abstract public class Fruit {
    /**
     * Вес фрукта
     */
    private final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    /**
     * Получение веса фрукта
     * @return вес фрукта
     */
    public float getWeight() {
        return weight;
    }
}
