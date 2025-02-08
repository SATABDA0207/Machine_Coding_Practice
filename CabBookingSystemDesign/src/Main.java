import com.cabBookingApp.service.DriverApplication;
import com.cabBookingApp.service.RiderApplication;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static DriverApplication driverApplication = new DriverApplication();
    private static RiderApplication riderApplication = new RiderApplication();


    public static void main(String[] args) {
        System.out.println("**** Welcome to Our Application ****");

        boolean run = true;
        while (run){
            printInstruction();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter Driver id: ");
                    String driverId = scanner.next();
                    System.out.println("Enter Cab id: ");
                    String cabId = scanner.next();
                    System.out.println("Enter First Location Value: ");
                    int cabFirstLocation = scanner.nextInt();
                    System.out.println("Enter Second Location Value: ");
                    int cabSecondLocation = scanner.nextInt();

                    driverApplication.registerCab(cabId, driverId, cabFirstLocation, cabSecondLocation);
                    break;
                case 2:
                    System.out.println("Enter Rider id: ");
                    String riderId = scanner.next();
                    System.out.println("Enter First Location Value: ");
                    int riderFirstLocation = scanner.nextInt();
                    System.out.println("Enter Second Location Value: ");
                    int riderSecondLocation = scanner.nextInt();

                    riderApplication.registerRider(riderId, riderFirstLocation, riderSecondLocation);
                    break;
                case 3:
                    System.out.println("Enter riderId: ");
                    String riderIdForBooking = scanner.next();
                    System.out.println("Enter destination first Location Value: ");
                    int riderFirstDestinationLocation = scanner.nextInt();
                    System.out.println("Enter destination Second Location Value: ");
                    int riderSecondDestinationLocation = scanner.nextInt();

                    riderApplication.bookRide(riderIdForBooking, riderFirstDestinationLocation,
                            riderSecondDestinationLocation);
                    break;
                case 4:
                    run = false;
                    break;
            }
        }
    }

    public static void printInstruction(){
        System.out.println("You can do the following operations: ");
        System.out.println("Press 1 to register a cab");
        System.out.println("Press 2 to register a rider");
        System.out.println("Press 3 to book a ride");
        System.out.println("Press 4 to Exit");
        System.out.println("Enter your response: ");
    }
}