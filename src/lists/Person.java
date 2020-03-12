package lists;

import java.util.ArrayList;

public class Person {
    private String firstName;
    private ArrayList<String> phone = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();

    Person(String firstName, String phone, String email) {
        this.firstName = firstName;
        this.phone.add(phone);
        this.email.add(email);
    }

    public void printPhone(){
        System.out.println(phone);
    }

    public void printEmail(){
        System.out.println(email);
    }

    public void setPhone(String phone) {
        this.phone.add(phone);
    }

    public void setEmail(String email) {
        this.email.add(email);
    }

    public String getFirstName() {
        return firstName;
    }
}
