package Homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CrossesZerosApp {

    public static char[][] map;
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public static int[] humanStep;


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
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
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
        humanStep = new int[2];
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
            humanStep[0] = x;
            humanStep[1] = y;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;

    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[x][y] == DOT_EMPTY) {
            return true;
        } else {
            return false;
        }
    }

    public static void aiTurn() {
        int x;
        int y;
        int [] result = new int[4];
        result[0]=checkHorizontalAfterHumanTurn();
        result[1]=checkVerticalAfterHumanTurn();
        result[2]=checkSideDiagonalAfterHumanTurn();
        result[3]=checkHeadDiagonalAfterHumanTurn();
        Arrays.sort(result);
        // Так как "Нолики", за который у нас играет компьютер практически
        // всегда находятся в положении проигравшего
        // напишем стратегию "защиты" от последнего хода человека.
        // Компьютер будет стараться найти наихудшую ситуацию
        // и залатать там дыру.
        if(result[3]==checkVerticalAfterHumanTurn()){
            int i=1;
            if(humanStep[0]+1>=SIZE) {
                while (i<SIZE) {
                    if (isCellValid(humanStep[0] - i, humanStep[1])) {
                        x = humanStep[0] - i;
                        y = humanStep[1];
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                    }
                    i++;
                }
            }
            else {
                while (i < SIZE) {
                    if (isCellValid(humanStep[0] + i, humanStep[1])) {
                        x = humanStep[0] + i;
                        y = humanStep[1];
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                        break;
                    }
                    i++;
                }
            }
            }
        else if (result[3]==checkHorizontalAfterHumanTurn()){
            int i=1;
            if(humanStep[1]+1>=SIZE){
                while (i<SIZE) {
                    if (isCellValid(humanStep[0], humanStep[1] - i)) {
                        x = humanStep[0];
                        y = humanStep[1] - i;
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                    }
                    i++;
                }
            }
            else {
                while (i < SIZE) {
                    if (isCellValid(humanStep[0], humanStep[1]+i)) {
                        x = humanStep[0] ;
                        y = humanStep[1]+i;
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                        break;
                    }
                    i++;
                }
            }
        }
        else if (result[3]==checkHeadDiagonalAfterHumanTurn()){
            int i=1;
            if(humanStep[0]+1>=SIZE && humanStep[1]+1>=SIZE || (humanStep[1]==0 && humanStep[0]==0)){
                    while (i < SIZE) {
                        if(isCellValid(humanStep[0]-i,humanStep[1]-i)) {
                        x = humanStep[0] - i;
                        y = humanStep[1] - i;
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                    }
                    i++;
                }
            }
            else {
                while (i < SIZE) {
                    if (isCellValid(humanStep[0] + i, humanStep[1]+i)) {
                        x = humanStep[0] + i;
                        y = humanStep[1]+i;
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                        break;
                    }
                    i++;
                }
            }
        }
        else if(result[3]==checkSideDiagonalAfterHumanTurn()){
            int i=1;
            if(humanStep[0]+1>=SIZE && humanStep[1]+1>=SIZE ||( humanStep[1]==0 || humanStep[0]==0)){
                while(i<SIZE){
                    if(isCellValid(humanStep[0]+i,humanStep[1]-i)) {
                        x = humanStep[0] + i;
                        y = humanStep[1] - i;
                        map[x][y]=DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                    }
                    i++;
                }
            }
            else {
                while (i < SIZE) {
                    if (isCellValid(humanStep[0] - i, humanStep[1]+i)) {
                        x = humanStep[0] - i;
                        y = humanStep[1]+i;
                        map[x][y] = DOT_O;
                        System.out.printf("Робот ходит в точку %d %d", x + 1, y + 1);
                        System.out.println();
                        break;
                    }
                    i++;
                }
            }
            }

    }

    public static int checkHorizontalAfterHumanTurn(){
        int result=0;
            for (int j=0; j<SIZE; j++){
                if (map[humanStep[0]][j] == DOT_X) {
                    result++;
                        }
                    }
        return result;
        }
    public static int checkVerticalAfterHumanTurn(){
        int result=0;
            for (int i=0; i<SIZE; i++){
                if (map[i][humanStep[1]] == DOT_X) {
                    result++;
            }
        }
        return result;
    }
    public static int checkHeadDiagonalAfterHumanTurn(){
        int result=0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j && map[i][j] == DOT_X) {
                    result++;
                }
            }
        }
        return result;
    }
    public static int checkSideDiagonalAfterHumanTurn(){
        int result=0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == (SIZE - j - 1) && map[i][j] == DOT_X) {
                    result++;
                }
            }
        }
        return result;
    }
    public static boolean checkWin(char sym) {
           if (checkDiagonalsToWin(sym)==true || checkLinesToWin(sym)==true){
               return true;
           }
           return false;
       }
    public static boolean checkDiagonalsToWin (char sym){
        int checkHeadDiagonal = 0;
        int checkSideDiagonal = 0;
        for (int i = 0; i < SIZE; i++) {
            int checkDiagonalUpHeadDiagonal = 0;
            int checkDiagonalUpSideDiagonal = 0;
            int checkDiagonalDownHeadDiagonal = 0;
            int checkDiagonalDownSideDiagonal = 0;
            for (int j = 0; j < SIZE; j++) {
                if (i == j && map[i][j] == sym) {
                    checkHeadDiagonal++;
                    if (j + 2 < SIZE) {
                        if (map[i + 1][j + 1] != sym && map[i + 1][j + 1] == DOT_EMPTY) {
                            checkHeadDiagonal = 0;
                        }
                    }
                }
                if (i == (SIZE - j - 1) && map[i][j] == sym) {
                    checkSideDiagonal++;
                    if (SIZE - i - 2 > 0 || SIZE - j - 2 > 0) {
                        if (map[SIZE - i - 1][SIZE - j - 1] != sym && map[SIZE - i-1][SIZE - j-1] == DOT_EMPTY) {
                            checkSideDiagonal = 0;
                        }
                    }
                }
                if (i < j && map[i][j] == sym) {
                    checkDiagonalUpHeadDiagonal++;
                    if (i + 2 < SIZE && j + 2 < SIZE) {
                        if (map[i + 1][j + 1] != sym && map[i + 1][j + 1] == DOT_EMPTY) {
                            checkDiagonalUpHeadDiagonal = 0;
                        }
                    }
                }
                if (i + j < SIZE + 1 && map[i][j] == sym) {
                    checkDiagonalUpSideDiagonal++;
                    if (SIZE - i - 2 > 0 || SIZE - j - 2 > 0) {
                        if (map[SIZE - i - 1][SIZE - j - 1] != sym && map[SIZE - i-1][SIZE - j-1] == DOT_EMPTY) {
                            checkDiagonalUpSideDiagonal = 0;
                        }
                    }
                }
                if (i > j && map[i][j] == sym) {
                    checkDiagonalDownHeadDiagonal++;
                    if (i + 2 < SIZE) {
                        if (map[i + 1][j + 1] != sym && map[i + 1][j + 1] == DOT_EMPTY) {
                            checkDiagonalDownHeadDiagonal = 0;
                        }
                    }
                }
                if (i + j > SIZE + 1 && map[i][j] == sym) {
                    checkDiagonalDownSideDiagonal++;
                        if (map[SIZE - i - 1][SIZE - j - 1] != sym && map[SIZE - i][SIZE - j] == DOT_EMPTY) {
                            checkDiagonalDownSideDiagonal = 0;
                        }

                }
                // Можно прописать одним if, но читать такое длинное условие невозможно(
                if (checkHeadDiagonal == DOTS_TO_WIN) {
                    return true;
                }
                if (checkSideDiagonal == DOTS_TO_WIN) {
                    return true;
                }
                if (checkDiagonalUpHeadDiagonal == DOTS_TO_WIN) {
                    return true;
                }
                if (checkDiagonalUpSideDiagonal == DOTS_TO_WIN) {
                    return true;
                }
                if (checkDiagonalDownHeadDiagonal == DOTS_TO_WIN) {
                    return true;
                }
                if (checkDiagonalDownSideDiagonal == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkLinesToWin (char sym){
        int checkHorizontal = 0;
        int checkVertical = 0;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (map[i][j] == sym) {
                    checkVertical++;
                    if (i+2 <SIZE){
                        if (map[i][j] != sym && map[i][j] == DOT_EMPTY) {
                            checkVertical = 0;
                        }
                    }
                }
            }
            if (checkVertical == DOTS_TO_WIN) {
                return true;
            }
            checkVertical = 0;
        }
        for (int i=0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == sym) {
                    checkHorizontal++;
                    if (j + 2 < SIZE) {
                        if (map[i][j + 1] != sym && map[i][j + 1] == DOT_EMPTY) {
                            checkHorizontal = 0;
                        }
                    }
                }
            }
            if (checkHorizontal == DOTS_TO_WIN) {
                return true;
            }
            checkHorizontal = 0;
        }
        return false;
    }
}


