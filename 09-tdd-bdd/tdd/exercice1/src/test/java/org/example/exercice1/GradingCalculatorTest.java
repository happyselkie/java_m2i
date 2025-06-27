package org.example.exercice1;

import org.junit.Assert;
import org.junit.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    @Test
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
    }

}
