
public class Implementation {
    public static void main(String[] args) {
        Methods M = new Methods();
        int choice;
        while (true) {
            choice = M.menu();
            if (choice == 1) {
                M.insert();
            } else if (choice == 2) {
                M.displayAll();
                break;
            }
        }
    }
}


