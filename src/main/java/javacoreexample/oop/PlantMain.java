package javacoreexample.oop;

import java.util.*;

public class PlantMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextNumber;

        ArrayList<Acacia> acaciaArrayList = new ArrayList<Acacia>();
        acaciaArrayList.add(new Acacia("Papilionaceae", "Acacia dealbata"));
        acaciaArrayList.add(new Acacia("Papilionaceae", "Acacia alata"));
        acaciaArrayList.add(new Acacia("Papilionaceae", "Acacia crassa"));

        Set<Rose> roseHashSet = new HashSet<>();
        roseHashSet.add(new Rose("Rosáceae", "White rose"));
        roseHashSet.add(new Rose("Rosáceae", "Red rose"));
        roseHashSet.add(new Rose("Rosáceae", "Yellow rose"));

        ArrayList<Rose> roseArrayList = new ArrayList<Rose>();
        roseArrayList.addAll(roseHashSet);

        do {
            System.out.println("What do you want?\n1 - show all acacias;" +
                    "\n2 - sort by acacia's name, compared in reverse order;" +
                    "\n3 - show all roses elements \n4 - show all roses elements in reverse order; " +
                    "\n5 - exit.");
            nextNumber = sc.nextInt();
            switch (nextNumber) {
                case 1:
                    for (Acacia acaciaList : acaciaArrayList)
                        acaciaList.display();
                    break;
                case 2:
                    Collections.sort(acaciaArrayList, new SortedByName());
                    Collections.reverse(acaciaArrayList);
                    for (Acacia acaciaCompare : acaciaArrayList)
                        acaciaCompare.display();
                    break;
                case 3:
                    for (Rose roseList : roseHashSet)
                        roseList.display();
                    break;
                case 4:
                    Collections.reverse(roseArrayList);
                    for (Rose roseCompare : roseArrayList)
                        roseCompare.display();
                    break;
                case 5:
                    System.out.println("Have a good day");
                    break;
                default:
                    System.out.println("wrong choice");
            }
        }
        while (nextNumber != 5);

    }

}