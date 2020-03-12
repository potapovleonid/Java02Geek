package lists;

public class PhoneBookMain {
    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();

        book.addPerson("Petrovich", "123456789", "sobaka@sobaka.ru");
        book.addPerson("Petrovich", "789456123", "sobaki@sobaki.ru");
        book.addPerson("Petrovich", "654321978", "soba@soba.ru");
        book.addPerson("Tsaregradcev", "987654321", "tsaregradcev@subaru.ru");
        book.addPerson("Tsaregradcev", "876543219", "tsaregradcev@skyline.ru");
        book.addPerson("Tsaregradcev", "765432198", "tsaregradcev@bmw.ru");
        book.addPerson("Ignatich", "123546789", "sobakaka@sobaba.ru");

        System.out.println("Царь");
        book.printPhone("Tsaregradcev");
        book.printEmail("Tsaregradcev");

        System.out.println("Игнатич");
        book.printPhone("Ignatich");
        book.printEmail("Ignatich");

        System.out.println("Петрович");
        book.printPhone("Petrovich");
        book.printEmail("Petrovich");



    }
}
