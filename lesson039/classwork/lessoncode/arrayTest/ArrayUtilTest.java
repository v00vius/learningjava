package arrayTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {

    ArrayUtil util = new ArrayUtil();

    @Test
  public void testFindMaxWithPositiveNumbers(){
      assertEquals("Максимальное значение должно быть 9", 9 ,util.findMax(new int[]{1, 2, 5, 7, 9}));
  }


    @Test
    public void testFindMaxWithNegativeNumbers(){
        assertEquals("Максимальное значение должно быть -1", -1 ,util.findMax(new int[]{-1, -2, -5, -7, -9}));
    }

    @Test
    public void testFindMaxWithMixNumbers(){
        assertEquals("Максимальное значение должно быть 9", 9 ,util.findMax(new int[]{-1, -2, 5, -7, 9}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindMaxWithEmptyArray(){
      util.findMax(new int[]{});
    }


}