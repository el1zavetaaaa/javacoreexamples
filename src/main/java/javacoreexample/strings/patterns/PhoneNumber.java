package javacoreexample.strings.patterns;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static void main(String[] args) {
        System.out.println("Please, enter the number: ");
        Scanner sc = new Scanner (System.in);
        String test = sc.nextLine();
        Pattern p = Pattern.compile("^(\\([0-9]{3}\\))[0-9]{7}$");
        Matcher m = p.matcher(test);
        if (m.matches())
            System.out.println("Right number");
        else System.out.println("Wrong number ");
    }
}
