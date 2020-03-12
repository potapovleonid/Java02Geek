package lists;

import java.util.HashMap;

public class PhoneBook {
    HashMap<String, Person> book = new HashMap<>();

    
    public void addPerson(String name, String phone, String email){
        if (book.get(name) == null) {
            Person person = new Person(name, phone, email);
            addHashMap(person);
        } else {
            book.get(name).setPhone(phone);
            book.get(name).setEmail(email);
        }
    }
    
    private void addHashMap(Person person){
        book.put(person.getFirstName(), person);
    }
    
    public void printPhone(String name){
        book.get(name).printPhone();
    }

    public void printEmail(String name){
        book.get(name).printEmail();
    }



}
