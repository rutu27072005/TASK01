import java.util.Scanner;
import java.util.Random;

public class CabBookingChatbot {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static String selectCab() {
        System.out.println("\n--- SELECT CAB ---");
        System.out.println("1. Auto  - Rs.12/km");
        System.out.println("2. Sedan - Rs.18/km");
        System.out.println("3. SUV   - Rs.25/km");
        System.out.print("Enter cab choice: ");

        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                return "Auto";
            case "2":
                return "Sedan";
            case "3":
                return "SUV";
            default:
                System.out.println("Invalid cab choice!");
                return null;
        }
    }

    static int getRate(String cab) {
        switch (cab) {
            case "Auto":
                return 12;
            case "Sedan":
                return 18;
            case "SUV":
                return 25;
            default:
                return 0;
        }
    }

    static String[] selectRoute() {
        System.out.println("\n--- SELECT ROUTE ---");
        System.out.println("1. Pune Station to Shivajinagar - 5 km");
        System.out.println("2. Swargate to Kothrud - 8 km");
        System.out.println("3. Hinjawadi to Wakad - 10 km");
        System.out.print("Enter route choice: ");

        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                return new String[]{"Pune Station", "Shivajinagar", "5"};
            case "2":
                return new String[]{"Swargate", "Kothrud", "8"};
            case "3":
                return new String[]{"Hinjawadi", "Wakad", "10"};
            default:
                System.out.println("Invalid route choice!");
                return null;
        }
    }

    static void bookRide() {
        String cab = selectCab();

        if (cab == null) {
            return;
        }

        String[] route = selectRoute();

        if (route == null) {
            return;
        }

        String source = route[0];
        String destination = route[1];
        int distance = Integer.parseInt(route[2]);
        int rate = getRate(cab);
        int fare = distance * rate;

        System.out.println("\n========== RIDE DETAILS ==========");
        System.out.println("Cab Type       : " + cab);
        System.out.println("Source         : " + source);
        System.out.println("Destination    : " + destination);
        System.out.println("Distance       : " + distance + " km");
        System.out.println("Rate per km    : Rs. " + rate);
        System.out.println("Total Fare     : Rs. " + fare);

        while (true) {
            System.out.println("\n--- BOOKING CONFIRMATION ---");
            System.out.println("1. Confirm & Share OTP");
            System.out.println("2. Cancel Ride");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    int otp = 1000 + random.nextInt(9000);
                    System.out.println("\nYour OTP is: " + otp);
                    System.out.println("Booking confirmed successfully!");
                    System.out.println(
                        "Cancellation is not allowed after OTP sharing."
                    );
                    return;

                case "2":
                    System.out.println("Ride cancelled successfully.");
                    System.out.println("No OTP has been shared.");
                    return;

                default:
                    System.out.println("Invalid choice! Enter 1 or 2.");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== CAB BOOKING CHATBOT ==========");
            System.out.println("1. Book Ride");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    bookRide();
                    break;

                case "2":
                    System.out.println(
                        "Thank you for using our Cab Booking Chatbot!"
                    );
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println(
                        "Invalid menu choice! Enter 1 or 2."
                    );
            }
        }
    }
}