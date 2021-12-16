package Homework6;

public abstract class Animals {
    protected String name;
    protected String typeOfDistance;
    protected int distance;
    private static int sum;

    public Animals(String name, String typeOfDistance){
        this.name = name;
        this.typeOfDistance = typeOfDistance;
        sum++;
    }
    public Animals (){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfDistance() {
        return typeOfDistance;
    }

    public void setTypeOfDistance(String typeOfDistance) {
        if (typeOfDistance.equals("water")) {
            this.typeOfDistance = typeOfDistance;
        }else if (typeOfDistance.equals("road")){
            this.typeOfDistance = typeOfDistance;
        }else{
            System.out.println("Wrong name of type");
        }
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public static void Score() {
        System.out.println(sum);
    }
    public abstract void running(int distance);
}
