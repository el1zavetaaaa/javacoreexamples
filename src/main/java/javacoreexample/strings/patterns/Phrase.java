package javacoreexample.strings.patterns;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phrase {
    public static void main(String[] args) {
        System.out.println("Please, enter the phrase: ");
        Scanner sc = new Scanner (System.in);
        String test = sc.nextLine();
        Pattern p = Pattern.compile("([a-zA-Z]+\\s[a-zA-Z]+)*");
        Matcher m = p.matcher(test);
        if (m.matches())
            System.out.println("This is a phrase");
        else System.out.println("It isn't a phrase");
    }
}
