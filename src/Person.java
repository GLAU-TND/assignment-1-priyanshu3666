public class Person {
    String first;
    String last;
    String[] phone;
    String email;
    Person next;

    Person(String first, String last, String[] phone, String email) {
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.email = email;
        next = null;

    }


}
