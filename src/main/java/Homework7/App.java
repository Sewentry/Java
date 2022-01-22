package Homework7;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 105);
        Cat cat1 = new Cat("Matia", 70);
        Cat cat2 = new Cat("Cilia", 90);
        Plate plate = new Plate(100);
        Cat[] cats = new Cat[] {cat,cat1,cat2};
        for (Cat i : cats)
        {
            i.eat(plate);
            i.info();
        }
        cat.eat(plate);
    }
}