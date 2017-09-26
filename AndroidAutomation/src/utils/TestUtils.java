package utils;

public class TestUtils {

    public static void outputIfMatchPassOrFail(String expectedValue, String actualValue){
        String result;
        if (expectedValue.trim().contains(actualValue.trim())){
            result = "(PASS)";
        } else {
            result = "(FAIL)";
        }

        System.out.println("Pass Fail Determination:");
        System.out.println("\t* Expected: " + expectedValue);
        System.out.println("\t* Actual: " + actualValue);
        System.out.println("===> " + result);
    }
}