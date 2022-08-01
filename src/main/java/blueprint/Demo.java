package blueprint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList( 2, 4,7, 8));

    }


    public static Integer defineSequence(List<Integer> list, Integer desiredNumber) {
        Integer result = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer summ = list.get(i);
            if (checkEquality(summ, desiredNumber)) {
                return summ;
            }
            for (int b = i + 1; b < list.size(); b++) {
                summ = summ + list.get(b);
                if (checkEquality(summ, desiredNumber)) {
                    return summ;
                } else if (summ > desiredNumber) {
                    continue;
                }
            }
        }

        return result;
    }

    private static boolean checkEquality(Integer actual, Integer expected) {
        System.out.println("checkEquality");
        return actual.equals(expected);
    }

}
