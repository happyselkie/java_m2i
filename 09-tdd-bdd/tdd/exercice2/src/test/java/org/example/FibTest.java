package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibTest {

    private Fib fib;

    // Avec un range de 1 : Le résultat n’est pas vide
    @Test
    public void whenRange_1_ThenNoEmptyResult(){
        fib = new Fib(1);

        List<Integer> result = fib.getFibSeries();

        Assert.assertFalse(result.isEmpty());
    }

    // Avec un range de 1 Le résultat correspond à une liste qui contient {0}
    @Test
    public void whenRange_1_ThenList_0(){
        fib = new Fib(1);

        List<Integer> result = fib.getFibSeries();
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(0);

        Assert.assertEquals(expectedResult, result);
    }

    // Avec un range de 6 Le résultat contient le chiffre 3
    @Test
    public void whenRange_6_ThenListContains_3(){
        fib = new Fib(6);

        List<Integer> result = fib.getFibSeries();

        Assert.assertTrue(result.contains(3));
    }

    // Avec un range de 6 Le résultat contient le chiffre 3
    @Test
    public void whenRange_6_ThenListSize_6(){
        fib = new Fib(6);

        List<Integer> result = fib.getFibSeries();

        Assert.assertTrue(result.size() == 6);
    }

    // Avec un range de 6 Le résultat n’a pas le chiffre 4 en son sein
    @Test
    public void whenRange_6_ThenListNotContains_4(){
        fib = new Fib(6);

        List<Integer> result = fib.getFibSeries();

        Assert.assertFalse(result.contains(4));
    }

    // Avec un range de 6 Le résultat est trié de façon ascendance
    @Test
    public void whenRange_6_ThenListAscendSort(){
        fib = new Fib(6);

        List<Integer> result = fib.getFibSeries();
        List<Integer> sortedResult = result.stream().sorted().toList();

        Assert.assertEquals(sortedResult, result);
    }

    // Avec un range de 6 Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
    @Test
    public void whenRange_6_ThenList(){
        fib = new Fib(6);

        List<Integer> result = fib.getFibSeries();
        List<Integer> expectedResult = new ArrayList<>();
        expectedResult.add(0);
        expectedResult.add(1);
        expectedResult.add(1);
        expectedResult.add(2);
        expectedResult.add(3);
        expectedResult.add(5);

        Assert.assertEquals(expectedResult, result);
    }



    // Test de liste avec un range de 1 et 6
    /*private static Stream<Arguments> provideValuesForGetFibSeries() {
        return Stream.of(
                Arguments.of(0, List.of(0)),
                Arguments.of(6, List.of(0, 1, 1, 2, 3, 5))
                );
    }
    @ParameterizedTest
    @MethodSource("provideValuesForGetFibSeries")
    public void whenRangeThenListIntExpected(int x, List<Integer> expected) {
        fib = new Fib(x);

        List<Integer> result = fib.getFibSeries();

        Assert.assertEquals(expected, result);
    }*/

}
