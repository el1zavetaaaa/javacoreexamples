package javacoreexample.testexamination;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindNumbersFromFile {
    public static void main(String[] args) throws IOException {


        FileReader inputFile = new FileReader("files\\10m.txt");

        Scanner scanNum = new Scanner(inputFile);
        ArrayList<Integer> listNum = new ArrayList<>();

        while (scanNum.hasNextInt()) {
            listNum.add(scanNum.nextInt());
        }

        int size = listNum.size();

//        for(int i = 0; i < size; i++){
//            System.out.println(listNum.get(i));
//        }

        System.out.println("Максимальное число в файле: " + getMaxValue(listNum) + "\n");
        System.out.println("Минимальное число в файле: " + getMinValue(listNum) + "\n");
        System.out.print("Среднее арифметическое значение: ");
        calculateAverage(listNum);
        System.out.println();
        System.out.print("Медиана: ");
        result_median(listNum, size);

        // This part of code doesn't work in the right way yet.
        System.out.print("\nНаибольшую последовательность идущих подряд чисел, которая увеличивается: ");
        System.out.println(findLengthOfLongestSubsequenceOfNumbers(listNum));
        longestSubsequenceOfNumbers(listNum);
        System.out.print("\nНаибольшую последовательность идущих подряд чисел, которая уменьшается: ");
        System.out.println(findLengthOfLongestSubsequenceOfNumbersThatDecrease(listNum));
        longestSubsequenceOfNumbersThatDecrease(listNum);


        inputFile.close();
    }

    public static int getMaxValue(ArrayList<Integer> arr) {
        int maxValue = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > maxValue) {
                maxValue = arr.get(i);
            }
        }
        return maxValue;
    }

    public static int getMinValue(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    private static void calculateAverage(ArrayList<Integer> arr) {
        double total = 0;
        double avg;
        for (int i = 0; i < arr.size(); i++) {
            total += arr.get(i);

        }
        avg = total / arr.size();
        String avgFormat = String.format("%.1f", avg);
        System.out.println((avgFormat));
    }

    public static int check_median(ArrayList<Integer> list) {
        Collections.sort(list);
        int size = list.size();
        int middle = size / 2;
        if ((size % 2) == 0) {
            int res = (list.get(middle - 1) + list.get(middle)) / 2;
            return res;
        } else {
            return list.get(middle);
        }
    }

    public static void result_median(ArrayList<Integer> arr, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(arr.get(i));
        }
        float med = check_median(list);
        System.out.println(med);
    }

    // This part of code doesn't work in the right way yet.

    public static void longestSubsequenceOfNumbers(ArrayList<Integer> arr) {
        int subSeqLength = 1;
        int longest = 1;
        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (i == 0 || arr.get(i - 1) > arr.get(i)) {
                subSeqLength++;
                if (subSeqLength > longest) {
                    longest = subSeqLength;
                    indexStart = i;
                    indexEnd = findLengthOfLongestSubsequenceOfNumbers(arr) + indexStart;
                }

            } else
                subSeqLength = 1;
        }

        for (int i = indexStart; i < indexEnd; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void longestSubsequenceOfNumbersThatDecrease(ArrayList<Integer> arr) {
        int subSeqLength = 1;
        int longest = 1;
        int indexStart = 0;
        int indexEnd = 0;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (i == 0 || arr.get(i - 1) < arr.get(i)) {
                subSeqLength++;
                if (subSeqLength > longest) {
                    longest = subSeqLength;
                    indexStart = i;
                    indexEnd = findLengthOfLongestSubsequenceOfNumbersThatDecrease(arr) + indexStart;
                }

            } else
                subSeqLength = 1;
        }

        for (int i = indexStart; i < indexEnd; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static int findLengthOfLongestSubsequenceOfNumbers(ArrayList<Integer> nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0 || nums.get(i - 1) > nums.get(i)) {
                result = Math.max(result, ++count);
            } else {
                count = 1;
            }
        }
        return result;
    }

    public static int findLengthOfLongestSubsequenceOfNumbersThatDecrease(ArrayList<Integer> nums) {
        int result = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i == 0 || nums.get(i - 1) < nums.get(i)) {
                result = Math.max(result, ++count);
            } else {
                count = 1;
            }
        }
        return result;
    }
}
