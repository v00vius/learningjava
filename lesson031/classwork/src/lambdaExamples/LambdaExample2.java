package lambdaExamples;

import java.util.Locale;

public class LambdaExample2 {
    public static void main(String[] args) {

        String myText = "Hello, World!";

        StringConvert stringConvert = (inputText -> inputText.toUpperCase());

        String convertResult = stringConvert.convertText(myText);
        System.out.println(convertResult);

        stringConvert = (text) -> text.toLowerCase();
        convertResult = stringConvert.convertText(myText);
        System.out.println(convertResult);

    }
}
