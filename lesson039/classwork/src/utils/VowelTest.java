package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class VowelTest {

@Test
public void countVowels()
{
        String test = "test";
        var expected = 1;
        var actual = Vowel.countVowels(test);

        assertEquals(expected, actual);
}
}