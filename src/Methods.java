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

    public void insert() {
        int f = 0;
        Person p = addContact();
        char priority = p.first.charAt(0);
        Person temp = front;
        if (front == null) {
            front = p;
            rear = p;
            temp = p;
        }

        while (temp.next != null) {

            if (priority > temp.first.charAt(0) && priority < temp.next.first.charAt(0)) {

                p = temp.next;
                temp.next = p;
                temp = p;
                return;
            } else
                f = 1;
            temp = temp.next;
        }
        if (f == 1) {
            rear.next = p;
            rear = p;
        }

    }


    public void displayAll() {
        Person temp = front;
        System.out.println("---Here are all your contacts---");
        while (temp != null) {
            int ctr = 0;
            int i = 0;

            System.out.println("-------- * -------- * -------- * --------");

            System.out.println("First Name :" + temp.first);
            System.out.println("Last Name:" + temp.last);
            while (temp.phone[i] != null) {
                ctr++;
                i++;
            }
            i = 0;
            if (ctr == 1) {
                System.out.println("Contact Number:" + temp.phone[0]);
            } else
                System.out.print("Contact Number(s):");
            while (temp.phone[i] != null) {
                System.out.print(temp.phone[i] + ", ");
                i++;
            }
            System.out.println("\b");
            System.out.println("Email address:" + temp.email);
        }
    }

    public void search() {
        Person temp = front;
        int ctr = 0;
        System.out.println("You could search for a contact from their first names: ");
        String s = sc.next();
        while (temp != null) {
            if (temp.first.equals(s))
                ctr++;

        }
        if (ctr == 0) {
            System.out.println("NO RESULTS FOUND!");
        } else {
            System.out.println(ctr + " match found!");
            while (temp != null) {
                int i = 0;
                System.out.println("First Name: " + temp.first + "/\n"
                        + "Last Name:" + temp.last + "\n");
                while (temp.phone[i] != null) {
                    ctr++;
                    i++;
                }
                i = 0;
                if (ctr == 1) {
                    System.out.println("Contact Number:" + temp.phone[0]);
                } else
                    System.out.print("Contact Number(s):");
                while (temp.phone[i] != null) {
                    System.out.print(temp.phone[i] + ", ");
                    i++;
                }
                System.out.println("\b");
                System.out.println("Email address:" + temp.email);

            }
        }
    }


    public void delete() {
        int i = 1;
        Person temp = front;
        while (temp != null) {
            System.out.println(i + ". " + temp.first + " " + temp.last);
            i++;
        }
        System.out.println("Press the number against contact to delete");
        int pos = sc.nextInt();
        i = 0;
        while (temp != null) {
            if (i != pos - 1) {
                temp = temp.next;
                i++;
            } else {
                System.out.println(temp.next.first + " " + temp.next.last + "Contact have been deleted");
                temp.next = temp.next.next;
            }
        }
    }


    public void exit() {

        System.out.println("Exitting .......");
        System.exit(0);
    }


}





