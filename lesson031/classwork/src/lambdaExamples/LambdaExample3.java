package lambdaExamples;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample3 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();


        list1.add("Toronto");
        list1.add("Berlin");
        list1.add("Leipzig");
        list1.add("London");

        list2.add("Paris");
        list2.add("Madrid");
        list2.add("Roma");
        list2.add("Istanbul");

        ListMerge merger = (listA, listB) ->
        {
            List<String> result = new ArrayList<>(listA);

            result.addAll(listB);

            return result;
        };

        List<String> list12 = merger.merge(list1, list2);

        System.out.println(list12);

    }
}
