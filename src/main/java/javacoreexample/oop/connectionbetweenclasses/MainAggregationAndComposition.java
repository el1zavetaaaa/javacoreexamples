package javacoreexample.oop.connectionbetweenclasses;

public class MainAggregationAndComposition {
    public static void main(String[] args) {
        Role role = new Role("ADMIN");

        UserAggregation userAggregation = new UserAggregation("user aggregation", role);

        System.out.println("Role for aggregation is: " + role.getName()
                + "\nUser for aggregation is: " + userAggregation.getName() + " "
        + userAggregation.getRoleName());

        UserComposition userComposition = new UserComposition("user composition");
        Role role1 = new Role("USER");
        userComposition.setRole(role1);

        System.out.println("Role for composition is: " + role.getName()
                + "\nUser for composition is: " + userComposition.getName() + " "
                + userComposition.getRoleName());
    }
}
