import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DestinationCity {
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of paths
        System.out.print("Enter the number of paths: ");
        int numOfPaths = scanner.nextInt();

        // Create a list to store paths
        List<List<String>> paths = new ArrayList<>();

        // Get input for each path
        for (int i = 0; i < numOfPaths; i++) {
            List<String> path = new ArrayList<>();

            System.out.print("Enter start city for path " + (i + 1) + ": ");
            path.add(scanner.next());

            System.out.print("Enter destination city for path " + (i + 1) + ": ");
            path.add(scanner.next());

            // Add the path to the list
            paths.add(path);
        }

        // Call destCity method
        String destinationCity = destCity(paths);

        // Display the result
        System.out.println("Destination City: " + destinationCity);

        // Close the scanner
        scanner.close();
    }

    public static String destCity(List<List<String>> paths) {
        HashSet<String> startCities = new HashSet<>();

        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }

        for (List<String> path : paths) {
            String dest = path.get(1);
            if (!startCities.contains(dest)) {
                return dest;
            }
        }

        return "";
    }
}
