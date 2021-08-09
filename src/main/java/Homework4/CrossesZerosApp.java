package Homework4;

import java.util.Random;
import java.util.Scanner;

public class CrossesZerosApp {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Выиграл человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компуктер выиграл");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        //верхние координаты
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            //левые координаты
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }
    public static boolean isCellValid(int x, int y) {
        //проверили что попали в массив
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        //проверим что ячейка подходит
        if (map[x][y] == DOT_EMPTY) {
            return true;
        } else {
            return false;
        }
    }
    public static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(SIZE); // [0, SIZE)
            y = RANDOM.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
        System.out.println();
        map[x][y] = DOT_O;
    }

    public static boolean checkWin(char sym) {
        int checkHorizontal = 0;
        int checkVertical = 0;
        int checkHeadDiagonal = 0;
        int checkSideDiagonal = 0;
        for (int i = 0; i<SIZE; i++)
        {
            for (int j=0; j<SIZE; j++)
            {
                    if (map[i][j] == sym) {
                        checkHorizontal++;
                        for (int k = j+1; k < SIZE; k++)
                        {
                            if (map[i][k] == DOT_O || map[i][k] == DOT_EMPTY ) {
                                checkHorizontal = 0;
                            }
                        }
                    }
                    if (i == j && map[i][j] == sym) {
                        checkHeadDiagonal++;
                        for (int k = j+1; k < SIZE; k++)
                        {
                            if (map[k][k] == DOT_O || map[k][k]==DOT_EMPTY) {
                                checkHeadDiagonal = 0;
                            }
                        }
                    }
                    if (i == (SIZE - j - 1) && map[i][j] == sym) {
                        checkSideDiagonal++;
                        for (int k = j+1; k < SIZE; k++)
                        {
                            if (map[SIZE-k-1][SIZE-k-1] == DOT_O || map[SIZE-k-1][SIZE-k-1]==DOT_EMPTY) {
                                checkSideDiagonal = 0;
                            }
                        }
                    }
            }
            if (checkHorizontal==DOTS_TO_WIN)
            {
                return true;
            }
            if(checkHeadDiagonal==DOTS_TO_WIN)
            {
                return true;
            }
            if(checkSideDiagonal==DOTS_TO_WIN)
            {
                return true;
            }
            checkHorizontal=0;
        }
        for (int j = 0; j<SIZE; j++)
        {
            for (int i=0; i<SIZE; i++)
            {
                if (map[i][j]==sym) {
                    checkVertical++;
                    for (int k = i+1; k < SIZE; k++)
                    {
                        if(map[k][j]==DOT_O)
                        {
                            checkVertical=0;
                        }
                    }

                }
            }
            if (checkVertical==DOTS_TO_WIN)
            {
                return true;
            }
            checkVertical=0;
        }
        return false;
    }


}
