package Homework6;

public class Cat extends Animals{
    private int sumCat = 0;

    public Cat(String name, String typeOfDistance){
        super (name,typeOfDistance);
        sumCat++;
    }
    public void catScore (){
        System.out.println(sumCat);
    }
    @Override
    public void running(int distance) {
        if (typeOfDistance.equals("water")) {
            System.out.println("Cats can't swimming");
        }else if(typeOfDistance.equals("road") && distance > 200) {
            System.out.println("distance is very big");
        }else
            System.out.println(name + " пробежал " + distance + "м");
    }
}
