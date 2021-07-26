package Homework2;


import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
    checkSum(10,20);
    Random random = new Random ();
    int value=random.nextInt(30000)-15000;
    checkSign(value);
    boolean ans = checkNegOrPos(value*(-1));
    System.out.println(ans);
    printer("Homework ", 2);
    boolean calc = calendar(value+15000);
    System.out.println(calc);
    }
    public static void checkSum (int a,int b)
    {
        if (a+b>10 && a+b<=2)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
    public static void checkSign (int a)
    {
        if (a>=0)
        {
            System.out.println("Положительное");
        }
        else
        {
            System.out.println("Отрицательное");
        }
    }
    public static boolean checkNegOrPos (int a)
    {
        if (a>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void printer (String s, int k )
    {
        for (int i = 0; i<k; i++) {
            System.out.println(s);
        }
    }
    public static boolean calendar (int a)
    {
        if (a%100==0 && a%400!=0 || a%4!=0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
