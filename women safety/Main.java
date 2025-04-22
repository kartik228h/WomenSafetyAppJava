import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Database db = new Database();
    static EmergencyService es = new EmergencyService();
    static ComplaintService cs = new ComplaintService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Women Safety App ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int c = sc.nextInt(); sc.nextLine();

            if (c == 1) register();
            else if (c == 2) login();
            else if (c == 3) { System.out.println("Stay Safe!"); break; }
            else System.out.println("Invalid choice");
        }
    }

    static void register() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Location: "); String loc = sc.nextLine();
        User u = db.registerUser(name, loc);
        System.out.println("Registered! Your ID: " + u.getId());
    }

    static void login() {
        System.out.print("Enter ID: "); String id = sc.nextLine();
        User u = db.loginUser(id);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Welcome, " + u.getName() + "!");
        userMenu(u);
    }

    static void userMenu(User u) {
        while (true) {
            System.out.println("\n1. Emergency SOS");
            System.out.println("2. Report Case");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            int o = sc.nextInt(); sc.nextLine();
            if (o == 1) es.sendSOS(u);
            else if (o == 2) {
                System.out.print("Complaint details: ");
                String d = sc.nextLine();
                cs.fileComplaint(u, d);
            }
            else if (o == 3) break;
            else System.out.println("Invalid option");
        }
    }
}
