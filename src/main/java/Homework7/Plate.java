package Homework7;

public class Plate {
        private int food;
        public Plate(int food) {
            this.food = food;
        }
        public void decreaseFood(int n,boolean satiety) {
            if (n>food)
                System.out.println("Food isn't enough");
            else {
                food -= n;
                 = true;
            }
        }
        public void info() {
            System.out.println("plate: " + food);
        }
}


