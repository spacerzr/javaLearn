public class Cat {
    private String name;
    private int appetite;
    private boolean isFull = false;
    private Sex sex;

    public Cat(String name, int appetite, Sex sex) {
        this.name = name;
        this.appetite = appetite;
        this.sex = sex;
    }
    public void eat(Plate p) {
        if(appetite > p.getFood()) {
            System.out.println("Для " + name + " в тарелке слишком мало еды");
            this.isFull = false;
        } else {
            p.decreaseFood(appetite);
            this.isFull = true;
            if(sex == Sex.MALE) {
                System.out.println(name + " покушал");
            } else {
                System.out.println(name + " покушала");
            }

        }
    }

    public void isFullInfo() {
        if(isFull) {
            if(sex == Sex.MALE) {
                System.out.println(name + " сытый");
            } else {
                System.out.println(name + " сытая");
            }
        } else {
            if(sex == Sex.MALE) {
                System.out.println(name + " голодный");
            } else {
                System.out.println(name + " голодная");
            }
        }
    }
}