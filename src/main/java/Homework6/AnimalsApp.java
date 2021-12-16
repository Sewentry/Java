package Homework6;

import static Homework6.Animals.*;

public class AnimalsApp {
    public static void main(String[] args) {
    Dog bobDog = new Dog("Bobik","water");
    Cat barsikCat = new Cat("Barsic","water");
    bobDog.running(150);
    barsikCat.running(10);
    Animals.Score();
    }
}
