public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int appetite) {
        this.food -= appetite;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public void increaseFood(int increase) {
        this.food += increase;
    }
}

