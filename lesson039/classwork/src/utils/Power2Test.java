package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class Power2Test {

int[] test1 = {1, 2, 4, 8, 16, -16, 0};
int[] test2 = {3, 5, 6, 7, -7};
@Test
public void isPower2test1()
{
        for (int x : test1) {
                boolean actual = Power2.isPower2(x);

                assertTrue(actual);
        }
}
@Test
public void isPower2test2()
{
        for (int x : test2) {
                boolean actual = Power2.isPower2(x);

                assertFalse(actual);
        }
}
}