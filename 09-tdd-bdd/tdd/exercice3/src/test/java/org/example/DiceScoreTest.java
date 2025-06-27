package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class DiceScoreTest {

    private DiceScore ds;
    private Ide de = Mockito.mock(Ide.class);

    // lorsque les 2 dés sont identiques on recupere bien valeur du dé * 2 + 10
    @Test
    public void whenTwoIdenticalDices_ThenTwiceDicePlusTen(){

        ds = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(10).thenReturn(10);

        int result = ds.getScore(de);
        int expected = (10*2) + 10;

        Assert.assertEquals(expected, result);
    }

    // dans le cas ou les 2 dés sont identiques et egaux a 6 on recupere 30
    @Test
    public void whenTwoIdentical6_Then30(){

        ds = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(6).thenReturn(6);

        int result = ds.getScore(de);
        int expected = 30;

        Assert.assertEquals(expected, result);
    }

    // dans le cas ou les dé sont quelconque on recupere la valeure du plus haut des 2

    @Test
    public void whenTwoDifferentDices_ThenGetMaxScore(){

        ds = new DiceScore();
        Mockito.when(de.getRoll()).thenReturn(4).thenReturn(5);

        int result = ds.getScore(de);
        int expected = 5;

        Assert.assertEquals(expected, result);
    }


}
