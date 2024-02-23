import java.util.Locale;

public class TestMethods {

    /*

    - метод substring() правильно обрезает строку. Например, когда мы
      вызываем substring(2, 4) для строки "hello", мы ожидаем получить "ll".

    - метод getAverage() возвращает правильное среднее значение для
      списка чисел.

    - метод getMax() возвращает правильное максимальное значение для
      списка чисел.
     */

    public String myUpperCase(String text){
        String textUpperCase = text.toUpperCase();
        return textUpperCase;
    }

    public boolean myContains(String text, String checkedText){
        boolean result = text.contains(checkedText);
        return result;
    }
}
