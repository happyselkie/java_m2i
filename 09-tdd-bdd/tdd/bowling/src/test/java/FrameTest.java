import org.example.BowlingBall;
import org.example.Frame;
import org.example.exception.IllegalRollException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    private Frame frame;
    private BowlingBall ball;
    private int score;

    @BeforeEach
    public void setup(){
        ball = Mockito.mock(BowlingBall.class);
        frame = new Frame(ball);
        score = frame.getScore();
    }

    @Test
    public void whenSerie_1_WithRoll_1_And_2_ThenUpgradeScore(){
        Mockito.when(ball.rollTheBall()).thenReturn(1).thenReturn(2);

        int actualScore = frame.play(1);

        Assertions.assertEquals(score + (1 + 2),actualScore);
    }

    @Test
    public void whenStandardPlayStrike_ThenUpdateScore(){
        Mockito.when(ball.rollTheBall()).thenReturn(10);

        int actualScore = frame.play(1);

        Assertions.assertEquals(score + 10,actualScore);
    }

    @Test
    public void whenStandardPlayStrikeAndSecondRoll_ThenScoreOnlyStrike(){
        Mockito.when(ball.rollTheBall()).thenReturn(10).thenReturn(2);

        int actualScore = frame.play(1);

        Assertions.assertEquals(score + 10,actualScore);
    }

    @Test
    public void whenStandardPlayThreeRoll_ThenScoreOnlyTwoRolls(){
        Mockito.when(ball.rollTheBall()).thenReturn(2).thenReturn(2).thenReturn(3);

        int actualScore = frame.play(1);

        Assertions.assertEquals(score + (2 + 2),actualScore);
    }

    @Test
    public void whenFinalSerieStrikeAndRoll_ThenUpgradeScoreAndNewRoll(){
        Mockito.when(ball.rollTheBall()).thenReturn(10).thenReturn(5).thenReturn(5);

        int actualScore = frame.play(10);

        Assertions.assertEquals(score + (10 + 5 + 5),actualScore);
    }

    @Test
    public void whenFinalSerieStrikeAndRollTwice_ThenUpgradeScoreAndOnlyOneNewRoll(){
        Mockito.when(ball.rollTheBall()).thenReturn(10).thenReturn(5).thenReturn(5).thenReturn(8);

        int actualScore = frame.play(10);

        Assertions.assertEquals(score + (10 + 5 + 5),actualScore);
    }

    @Test
    public void whenFinalSerieSpareAndRoll_ThenUpgradeScore(){
        Mockito.when(ball.rollTheBall()).thenReturn(6).thenReturn(4).thenReturn(6);

        int actualScore = frame.play(10);

        Assertions.assertEquals(score + (6 + 4 + 6),actualScore);
    }

    @Test
    public void whenFinalSerieOverThreeRoll_ThenScoreOnlyTwoRolls(){
        Mockito.when(ball.rollTheBall()).thenReturn(2).thenReturn(2).thenReturn(3).thenReturn(3);

        int actualScore = frame.play(10);

        Assertions.assertEquals(score + (2 + 2),actualScore);
    }

}
