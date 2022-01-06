package javacoreexample.strings.commonsymbols;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonSymbols {

    public static void main(String[] args) {

        String firstString = "At med school, Doyle met his mentor, Professor Dr. Joseph Bell, " +
                "whose keen powers of observation would later inspire Doyle to create his famed fictional detective character," +
                " Sherlock Holmes.";

        String secondString = "Sir Arthur Conan Doyle designed a golf course in 1914 while on a visit " +
                "to Jasper National Park in Alberta, Canada.";
        int k = 0;

        while (k != 4) {
            Scanner in = new Scanner(System.in);
            System.out.print("1. Get common symbols. \n" +
                    "2. Get symbols,which are located in, at least, one string. \n" +
                    "3. Get symbols, which are located in only first string.  \n" +
                    "4. Exit. \n" +
                    "Choose variant:");
            int j = in.nextInt();
            boolean shouldBreak = false;
            switch (j) {
                case (1):
                    getCommonSymbols(firstString, secondString);
                    break;

                case (2):
                    getUncommonSymbols(firstString, secondString);
                    break;

                case (3):
                    System.out.println("\n Unique symbols, which are located in only first string, in Usual Order are: "
                            + getElementsWhichContainsInOnlyFirstString(firstString, secondString) + "\n");
                    break;

                case (4):
                    shouldBreak = true;
                    System.out.println("Thank you for attention!");
            }
            if (shouldBreak) break;
        }
    }


    static void getCommonSymbols(String firstString, String secondString) {


        System.out.print("\n Given firstString : " + firstString + "\n");
        System.out.print("\n Given secondString : " + secondString + "\n");

        Set<Character> setOfCharacters1 = new HashSet<Character>();
        Set<Character> setOfCharacters2 = new HashSet<Character>();

        for (char charSetFromFirstString : firstString.toCharArray()) {
            setOfCharacters1.add(charSetFromFirstString);
        }
        for (char charSetFromSecondString : secondString.toCharArray()) {
            setOfCharacters2.add(charSetFromSecondString);
        }

        setOfCharacters1.retainAll(setOfCharacters2);

        System.out.print("\n Common symbols are: ");
        for (char charactersFromSets : setOfCharacters1) {
            System.out.print(charactersFromSets);
        }

        System.out.print("\n Reverse order of chars: ");

        Object[] charArray = setOfCharacters1.toArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            System.out.print(charArray[i] + "  ");
        }

        System.out.println("\n Total number of common characters: "
                + setOfCharacters1.size() + "\n");
    }

    static void getUncommonSymbols(String string1, String string2) {
        System.out.print("\n Given firstString : " + string1 + "\n");
        System.out.print("\n Given secondString : " + string2 + "\n");

        HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
        for (int i = 0; i < string1.length(); i++) {
            h1.add(string1.charAt(i));
        }
        for (int i = 0; i < string2.length(); i++) {
            h2.add(string2.charAt(i));
        }

        StringBuffer uniqueSB = new StringBuffer();

        for (Character i : h1) {
            if (!h2.contains(i)) {
                uniqueSB.append(i);
            }
        }

        for (Character i : h2) {
            if (!h1.contains(i)) {
                uniqueSB.append(i);
            }
        }

        System.out.println("\n Unique symbols are:" + uniqueSB.toString().replace(" ", ""));
        String reverse = new StringBuffer(uniqueSB).reverse().toString();
        System.out.println("\n Unique symbols in Reverse Order are:" + reverse + "\n");
    }


    static int[] getCharCountArray(String str) {
        final int NO_OF_CHARS = 256;
        int count[] = new int[NO_OF_CHARS];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        return count;
    }

    static String getElementsWhichContainsInOnlyFirstString(String string1,
                                                            String string2) {
        System.out.print("\n Given firstString : " + string1 + "\n");
        System.out.print("\n Given secondString : " + string2 + "\n");

        int count[] = getCharCountArray(string2);
        int ip_ind = 0, res_ind = 0;

        char arr[] = string1.toCharArray();

        while (ip_ind != arr.length) {
            char temp = arr[ip_ind];
            if (count[temp] == 0) {
                arr[res_ind] = arr[ip_ind];
                res_ind++;
            }
            ip_ind++;
        }

        string1 = new String(arr);

        String reverse = new StringBuffer(string1.substring(0, res_ind)).reverse().toString();
        System.out.println("\n Unique symbols in Reverse Order are:" + reverse);

        return string1.substring(0, res_ind);

    }

}

