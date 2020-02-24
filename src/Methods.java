import java.util.Scanner;

public class Methods {
    Scanner sc;
    Person p;
    Person front;
    Person rear;

    Methods() {
        sc = new Scanner(System.in);
        p = null;
        front = null;
        rear = null;
    }

    public int menu() {
        int choice = 0;
        System.out.println("Welcome to DBC's Contact List App\n" +
                "Press 1 to add a new contact\n" +
                "Press 2 to view all contacts\n" +
                "Press 3 to search for a contact\n" +
                "Press 4 to delete a contact\n" +
                "Press 5 to exit program ");
        choice = sc.nextInt();
        return choice;

    }

    private boolean selection() {

        char c = sc.next().charAt(0);
        if (c == 'Y' || c == 'y') {
            return true;
        } else if (c == 'N' || c == 'n') {
            return false;
        } else {
            return false;
        }
    }

    private Person addContact() {
        String choice = null;
        String phone[] = new String[10];
        int i = 0;
        String email = null;
        String first = null;
        String last = null;

        System.out.println("First Name : ");
        first = sc.next();
        System.out.println("Last Name : ");
        last = sc.next();

        do {
            System.out.print("Phone number : ");
            phone[i] = sc.next();
            System.out.print("Would you like to add another contact number? (y/n)");
            i++;
        }
        while (selection());

        System.out.print("Would you like to add email address? (y/n)");
        if (selection())
            email = sc.next();

        p = new Person(first, last, phone, email);

        return p;
    }


}
