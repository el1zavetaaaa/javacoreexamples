package javacoreexample.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/** Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
 Print the decimal value of each fraction on a new line with  places after the decimal.*/

public class FoundTheRatioFromAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr) {
        int sizeOfAnArray = arr.size();

        double negative = 0;
        double positive = 0;
        double zero = 0;

        List<Double> ratioList = new ArrayList<>();

        for (int index : arr) {
            if (index < 0) {
                negative++;
            }
            if (index == 0) {
                zero++;
            }
            if (index > 0) {
                positive++;
            }
        }

        double negativeRatio = negative / sizeOfAnArray;
        double zeroRatio = zero / sizeOfAnArray;
        double positiveRatio = positive / sizeOfAnArray;

        ratioList.add(negativeRatio);
        ratioList.add(zeroRatio);
        ratioList.add(positiveRatio);

        for (double ratioListObject : ratioList) {
            System.out.printf("%.6f \n", ratioListObject);
        }

    }

}

