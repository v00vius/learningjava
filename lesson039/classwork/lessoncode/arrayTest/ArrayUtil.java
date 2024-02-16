package arrayTest;

public class ArrayUtil {

    public int findMax(int[] workingArray){
        if (workingArray == null || workingArray.length == 0){
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int max = workingArray[0];
        for (int value : workingArray){
            if (value > max) max = value;
        }

        return max;
    }
}
