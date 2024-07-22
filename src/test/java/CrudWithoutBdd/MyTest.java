package CrudWithoutBdd;

import org.testng.annotations.Test;

public class MyTest {
    private String myString;

    @Test
    public void test1() {
        myString = "Value for test1";
        System.out.println("Test 1: " + myString);
    }

    @Test
    public void test2() {
        System.out.println("Test 2: " + myString);
    }
}
