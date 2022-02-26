package javacoreexample.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**Given five positive integers,
 * find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 Then print the respective minimum and maximum values as a single line of two space-separated long integers.***/

public class GetMinimumAndMaximumValuesByAddingFourNumbersOfAnArray {
    public static void main(String[] args) throws IOException {
        System.out.println("Please enter an array of integers: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        int max =0;
        int min =1_000_000;
        int totalSum=0;

        for(int elementOfAnArray: arr ){
            if(elementOfAnArray > max){
                max = elementOfAnArray;
            }

            if(elementOfAnArray< min){
                min = elementOfAnArray;
            }

            totalSum += elementOfAnArray;
        }

        System.out.println("Minimal sum of an array " + (totalSum - max));
        System.out.println("Maximum sum of an input array "+ (totalSum-min));
    }
}