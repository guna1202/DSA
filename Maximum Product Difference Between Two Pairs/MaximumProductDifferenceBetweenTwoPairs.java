import java.util.Scanner;

public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Call the maxProductDifference method and print the result
        int result = maxProductDifference(nums);
        System.out.println("The maximum product difference is: " + result);

        // Close the scanner
        scanner.close();
    }
  
    public static int maxProductDifference(int[] nums) {
        int largest = 0;
        int secondLargest = 0;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }

        return (largest * secondLargest) - (smallest * secondSmallest);
    }
}
