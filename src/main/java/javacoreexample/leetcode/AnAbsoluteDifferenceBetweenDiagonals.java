package javacoreexample.leetcode;

public class AnAbsoluteDifferenceBetweenDiagonals {
    public static void main(String[] args) {

        int upToDown =0;
        int downToUp =0;
        int[][] arr = {{1,2,3}, {4,5,6}, {9,8,9}};

        for (int i = 0; i < arr.length; i++) {
            upToDown += arr[i][i];
            downToUp += arr[arr.length - (i+1)][i];
        }
        System.out.println(Math.abs(upToDown-downToUp));
    }
}
