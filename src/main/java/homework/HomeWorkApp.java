package homework;

public class HomeWorkApp {
    public static void main(String[] args)
    {
        printThreeWords ();
        checkSumSign();
        printColor();
        compareNumbers();
    }
        public static void printThreeWords ()
            {
                System.out.println("Orange");
                System.out.println("Banana");
                System.out.println("Apple");
            }
        public static void checkSumSign ()
            {
                int a,b;
                a=10;
                b=-2;
                if (a+b>0)
                    System.out.println("Сумма положительная");
                else
                    System.out.println("Сумма отрицательная");
            }
        public static void  printColor()
            {
            int value = (int)(Math.random()*400)-200; // захотел использовать ф-ю Random, которую изучили в Вводном курсе
            // а то как-то неинтересно. Добавил ей возможность рандомизировать отрицательные числа
            // надеюсь, по рукам бить не будете:)
            if (value <= 0)
                System.out.println("Красный");
            else if (value <= 100)
                System.out.println("Желтый");
            else
                System.out.println("Зеленый");
            }
        public static void compareNumbers()
            {
                int a,b;
                a=(int)(Math.random()*10000);
                b=(int)(Math.random()*10000);
                if (a>=b)
                    System.out.println("a>=b");
                else
                    System.out.println("a<b");
            }
}
