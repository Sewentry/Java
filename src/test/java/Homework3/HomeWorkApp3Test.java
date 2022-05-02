package Homework3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class HomeWorkApp3Test {
    private HomeWorkApp3 homeWorkApp3;

    @BeforeAll
    public static void startTest(){
        System.out.println("Start Equilibrium test!");
    }
    @AfterAll
    public static void endTest(){
        System.out.println("End test!");
    }


    @ParameterizedTest
    @MethodSource("dataForTestEquilibrium")
    public void testEquilibrium(int[] arr){
        Assertions.assertTrue(HomeWorkApp3.checkEquilibriumArray(arr));
    }
    public static Stream<Arguments> dataForTestEquilibrium(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {2, 2, 2, 1, 2, 2, 10, 1}));
        out.add(Arguments.arguments(new int[] {1, 1, 1,2, 1}));
        out.add(Arguments.arguments(new int[] {3,4,5,6,7}));
        out.add(Arguments.arguments(new int[] {1,1,1,1,1,1,1,1}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataCyclicShiftArray")
    public void testcyclicShiftArray(int[] arr, int shift, int[] result){
        Assertions.assertArrayEquals(result, HomeWorkApp3.cyclicShiftArray(arr, shift));
    }

    public static Stream<Arguments> dataCyclicShiftArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[] {1, 2, 3},1, new int[]{3, 1, 2}));
        out.add(Arguments.arguments(new int[] {3, 5, 6, 1},-2, new int[]{6,1,3,5}));
        out.add(Arguments.arguments(new int[] {1,1,1,1},1, new int[]{1,1,1,1}));
        out.add(Arguments.arguments(new int[] {1,2,3},0, new int[]{1,2,3}));

        return out.stream();
    }
}

