package javacoreexample.streamapi.model;

public class Account {
    private int id;
    private String firstName;
    private String lastName;
    private int balance;
    private String birthdayMonth;
    private String sex;
    private String email;
    private int yearOfCreation;

    public Account(int id, String firstName, String lastName, int balance, String birthdayMonth, String sex, String email, int yearOfCreation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.birthdayMonth = birthdayMonth;
        this.sex = sex;
        this.email = email;
        this.yearOfCreation = yearOfCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", balance=" + balance +
                ", birthdayMonth='" + birthdayMonth + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                '}';
    }
}
