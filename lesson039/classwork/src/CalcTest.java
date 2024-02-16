import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {
Calc calc = new Calc();

@Test
public void test1()
{
        double expected = 6.;
        double actual = calc.mul(2., 3.);

        assertEquals(expected, actual, 1e-3);
}

@Test
public void mul()
{

}
}