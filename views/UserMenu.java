package views;
import java.util.Scanner;

public class UserMenu extends CommonMenu {
    public void UserMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("USER MENU:");
        System.out.println("1-Update Profile");
        System.out.println("2-View Flower List");
        System.out.println("3-Add Flower List");
        System.out.println("4-View Order");
        System.out.println("5-Cancel Order");
        System.out.println("6-Quit");
        System.out.print("Enter your choice: ");
        int choose = sc.nextInt();
        sc.nextLine();
        switch (choose) {
            case 1:
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter address: ");
                String address = sc.nextLine();
                System.out.print("Enter Phone number: ");
                String phone = sc.nextLine();

                break;

            case 2:
            
                break;

            case 3:
            
                break;

            case 4:
            
                break;

            case 5:
            
                break;

            case 6:
            
            
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        UserMenu mn = new UserMenu();
        mn.UserMenu();
    }
}
