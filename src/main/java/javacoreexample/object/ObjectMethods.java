package javacoreexample.object;

public class ObjectMethods {
    public static void main(String[] args) {
        Object object = new Object();
        Integer integer1 = 10;
        Integer integer2 = 10;
        Integer integer3 = 10;
        System.out.println("Object class: " + object.getClass());
        System.out.println("Object hashcode: " + object.hashCode());
        System.out.println("Equals method: " + integer1.equals(integer2));
        System.out.println("Hashcode for 1st integer: " + integer1.hashCode()
                + "\nHashcode for 2nd integer: " + integer2.hashCode());
        System.out.println("Transitive: if integer 1= " + integer1
                + " and integer2= " + integer2 + " are equals: "
                + integer1.equals(integer2) + "\nand integer2 ="
                + integer2 + " ,integer3= " + integer3 +
                " are equals: " + integer2.equals(integer3)
                + "\nthen integer1= " + integer1 + " & integer3= "
                + integer3 + " are equals: " + integer1.equals(integer3));
        System.out.println("No-null reference: " + integer1.equals(null));
        System.out.println(object.toString());
    }
}
