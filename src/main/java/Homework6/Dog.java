package Homework6;

public class Dog extends Animals{
    private int sumDog = 0;

    public Dog(String name, String typeOfDistance){
        super (name,typeOfDistance);
            sumDog++;
        }



    public void dogScore (){
        System.out.println(sumDog);
    }
    @Override
    public void running(int distance) {
        if (typeOfDistance.equals("water") && distance > 10) {
            System.out.println("distance is very big");
        }else if(typeOfDistance.equals("road") && distance > 500) {
            System.out.println("distance is very big");
        }else
        System.out.println(name + " пробежал " + distance + "м");
    }
}
