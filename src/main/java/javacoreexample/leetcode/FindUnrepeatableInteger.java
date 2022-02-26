package javacoreexample.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindUnrepeatableInteger {
    public static void main(String[] args) {
        int selectedItem = 0;
        List<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers.add(1);
        arrayOfIntegers.add(2);
        arrayOfIntegers.add(3);
        arrayOfIntegers.add(4);
        arrayOfIntegers.add(3);
        arrayOfIntegers.add(2);
        arrayOfIntegers.add(1);

        for (int i = 0; i < arrayOfIntegers.size(); i++) {
            int frequency = Collections.frequency(arrayOfIntegers, arrayOfIntegers.get(i));
            if (frequency == 1) {
                selectedItem = arrayOfIntegers.get(i);
                break;
            }
        }
        System.out.println(selectedItem);
    }
}
