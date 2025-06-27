package org.example.exercice1;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;


    // Méthode 1 :
    /*private static Stream<Arguments> provideValuesForGradingCalculator() {
        return Stream.of(
                Arguments.of(95, 90, 'A'),
                Arguments.of(85, 90, 'B'),
                Arguments.of(65, 90, 'C'),
                Arguments.of(95, 65, 'B'),
                Arguments.of(95, 55, 'F'),
                Arguments.of(65, 55, 'F'),
                Arguments.of(50, 90, 'F')
        );
    }

    @ParameterizedTest(name = "Score : {0}%, Présence : {1} => Note: {2}")
    @MethodSource("provideValuesForGradingCalculator")
    public void whenScore_x_attendancePercentage_y_Then_Z(int x, int y, char z){
        gradingCalculator = new GradingCalculator(x, y);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals(z, result);
    }*/

    // Méthode 2 :
    @ParameterizedTest
    @CsvSource({
            "95, 90, 'A'",
            "85, 90, 'B'",
            "65, 90, 'C'",
            "95, 65, 'B'",
            "95, 55, 'F'",
            "65, 55, 'F'",
            "50, 90, 'F'"
            })
    public void whenScore_x_attendancePercentage_y_Then_Z(int x, int y, char z){
        gradingCalculator = new GradingCalculator(x, y);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals(z, result);
    }

    /*/
    /*@Test
    public void whenScore_95_attendancePercentage_90_Then_A(){
        gradingCalculator = new GradingCalculator(95, 90);

        // ACT
        char result = gradingCalculator.getGrade();

        // ASSERT
        Assert.assertEquals('A', result);
    }

    @Test
    public void whenScore_85_attendancePercentage_90_Then_B(){
        gradingCalculator = new GradingCalculator(85, 90);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('B', result);
    }

    @Test
    public void whenScore_65_attendancePercentage_90_Then_C(){
        gradingCalculator = new GradingCalculator(65, 90);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('C', result);
    }

    @Test
    public void whenScore_95_attendancePercentage_65_Then_B(){
        gradingCalculator = new GradingCalculator(95, 65);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('B', result);
    }

    @Test
    public void whenScore_95_attendancePercentage_55_Then_F(){
        gradingCalculator = new GradingCalculator(95, 55);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('F', result);
    }

    @Test
    public void whenScore_65_attendancePercentage_55_Then_F(){
        gradingCalculator = new GradingCalculator(65, 55);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('F', result);
    }

    @Test
    public void whenScore_50_attendancePercentage_90_Then_F(){
        gradingCalculator = new GradingCalculator(50, 90);

        char result = gradingCalculator.getGrade();

        Assert.assertEquals('F', result);
    }*/

}
