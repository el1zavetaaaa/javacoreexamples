package javacoreexample.oop.inheritancecomparatorcollection;

import java.util.Comparator;

public class SortedByName implements Comparator<Acacia> {
    public int compare (Acacia obj1, Acacia obj2) {

        String str1 = obj1.getAcaciaName();
        String str2 = obj2.getAcaciaName();

        return str1.compareTo(str2);
    }
}