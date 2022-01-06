package javacoreexample.oop.connectionbetweenclasses;

public class UserAggregation {
    private String name;
    private Role role;

    public UserAggregation(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoleName(){
        return role.getName();
    }
}
