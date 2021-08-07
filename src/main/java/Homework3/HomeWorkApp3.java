package Homework3;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        Random random = new Random ();
        int [] arr = new int[11];
        int [] arr1 = new int[100];
        int [] arr2 = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int [][] arr3 = new int [5][5];
        int [] arr4 = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        int [] arr5 = new int[]{1, 2, 3};
        for (int i = 0; i<11;i++) {
            int value = random.nextInt(2);
            arr[i]=value;
        }
        for (int i=0; i<arr3.length;i++) {
            Arrays.fill(arr3[i], 0);
        }
        invertArray(arr);
        autoFilling(arr1);
        changeArray(arr2);
        add1IntoDiagonal(arr3);
        createArray(6,6);
        findMaxElement(arr1);
        findMinElement(arr2);
        checkEquilibriumArray(arr4);
        cyclicShiftArray(arr5,1);
        System.out.println(Arrays.toString(arr5));



    }
    public static void invertArray (int[] arr) {
    for (int i = 0; i< arr.length;i++)
    {
        if (arr[i]==1) {
            arr[i]=0;
        }
        else {
        arr[i]=1;
        }
    }
    }
    public static void autoFilling (int[] arr){
        int k=1;
        for (int i = 0; i<arr.length;i++)
        {
            arr[i]=k;
            k++;
        }
    }
    public static void changeArray (int[] arr){
        for (int i=0;i<arr.length; i++)
        {
            if (arr[i]<6)
                arr[i]*=2;
        }
    }
    public static void add1IntoDiagonal(int[][] arr){
        for (int i=0; i<arr.length;i++)
            for (int j=0;j<arr[i].length; j++)
            {
                if (i==j) {
                    arr[i][j] = 1;
                }
                if (i==arr.length-j-1)
                {
                    arr[i][j]=1;
                }
            }
    }
    public static int createArray(int len, int initialValue){
        int[] arr4 = new int[len];
        for (int i=0; i<len;i++) {
            arr4[i]=initialValue;
        }
        return arr4[len-1];
        }
    public static int findMinElement (int[] arr)
    {
        Arrays.sort(arr);
        return arr[0];
    }
    public static int findMaxElement (int[] arr)
    {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
    public static boolean checkEquilibriumArray (int[] arr)
    {
        int checkl=0;
        int checkr=0;
        for (int i=0; i<arr.length;i++) {
            checkl += arr[i];
            for (int j = i+1; j < arr.length; j++) {
                checkr += arr[j];
            }
            if (checkl == checkr) {
                return true;
            }
            checkr=0;
        }
            return false;
    }
    public static int cyclicShiftArray (int [] arr, int shift)
    {
        if(shift==0)
        {
            return arr[arr.length-1];
        }

            if (shift>0)
            {
                if (shift>arr.length)
                {
                    shift=shift-arr.length;
                }
                for (int i = 0;i<shift; i++)
                {
                    int store = arr[0];
                    arr[0]=arr[arr.length-1];
                    for(int j=1; j<arr.length-1; j++)
                    {
                        arr[arr.length-j]=arr[arr.length-j-1];
                    }
                    arr[1]=store;
                }
            }
            else
            {
                if (Math.abs(shift)>arr.length)
                {
                    shift=shift+arr.length;
                }
                for (int i = 0;i>shift; i--)
                {
                    int store = arr[arr.length-1];
                    arr[arr.length-1]=arr[0];
                    for(int j=1; j<arr.length-1; j++)
                    {
                        arr[j-1]=arr[j-2];
                    }
                    arr[arr.length-2]=store;
                }
            }
        return arr[arr.length-1];
    }
}

