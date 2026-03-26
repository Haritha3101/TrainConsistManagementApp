import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("======================================\n");

        List<String> passengerBogies = new ArrayList<>();

        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();

        passengerBogies.remove("AC Chair");

        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();

        boolean hasSleeper = passengerBogies.contains("Sleeper");

        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + hasSleeper);
        System.out.println();

        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);
        System.out.println();

        System.out.println("UC2 operations completed successfully...");
    }
}