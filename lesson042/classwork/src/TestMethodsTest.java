import org.junit.Test;

import static org.junit.Assert.*;

public class TestMethodsTest {

    TestMethods methods = new TestMethods();


    @Test
    public void myUpperCaseTest() {
        String testData = "JaVa";
        String expectedResult = "JAVA";
        String actualResult = methods.myUpperCase(testData);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void myContainstest() {
        String testData = "hello world";
        String checkedText = "world";

        boolean actualResult = methods.myContains(testData,checkedText);

        assertTrue(actualResult);
    }
}