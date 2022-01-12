package Homework7;

public class Plate {
        private int food;
        public Plate(int food) {
            this.food = food;
        }
        public void decreaseFood(int n,boolean a) {
            if (n>food)
                System.out.println("Food isn't enough");
            else {
                food -= n;
                 a = true;
            }
        }
        public void info() {
            System.out.println("plate: " + food);
        }
}


