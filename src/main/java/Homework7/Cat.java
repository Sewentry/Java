package Homework7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite,satiety);
    }
    public void info(){
        System.out.println("satiety:  " + satiety);
    }
}

