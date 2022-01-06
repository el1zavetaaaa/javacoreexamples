package javacoreexample.oop.connectionbetweenclasses;


public class UserComposition {
    private String name;
    private Role role;

    public UserComposition(String name) {
        this.name = name;
        this.role = new Role();
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
