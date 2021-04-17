public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 3, Sex.MALE);
        Cat cat2 = new Cat("Мурка", 10, Sex.FEMALE);
        Cat cat3 = new Cat("Васька", 7, Sex.MALE);
        Cat cat4 = new Cat("Пушок", 12, Sex.MALE);
        Cat cat5 = new Cat("Лапушок", 4, Sex.MALE);

        Cat[] cats = new Cat[5];
        cats[0] = cat1;
        cats[1] = cat2;
        cats[2] = cat3;
        cats[3] = cat4;
        cats[4] = cat5;

        Plate plate = new Plate(50);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.isFullInfo();
        }
        plate.info();
        plate.increaseFood(15);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.isFullInfo();
        }
        plate.info();
    }
}