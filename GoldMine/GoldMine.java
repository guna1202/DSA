import java.util.Scanner;

public class GoldMine {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (n): ");
    int n = scanner.nextInt();

    System.out.print("Enter the number of columns (m): ");
    int m = scanner.nextInt();

    int[][] arr = new int[n][m];

    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    int result = maxGold(n, m, arr);

    System.out.println("Maximum Gold: " + result);

    scanner.close();
  }
  
  public static int maxGold(int n, int m, int arr[][]) {
    int dp[][] = new int[n][m];

    // Initialize the last column of the dp table
    for (int i = 0; i < n; i++) {
        dp[i][m - 1] = arr[i][m - 1];
    }

    // Dynamic Programming: Bottom-up approach
    for (int j = m - 2; j >= 0; j--) {
        for (int i = 0; i < n; i++) {
            int up = (i > 0) ? dp[i - 1][j + 1] : 0;
            int down = (i < n - 1) ? dp[i + 1][j + 1] : 0;
            int right = dp[i][j + 1];

            // Update the current cell with the maximum value
            dp[i][j] = arr[i][j] + Math.max(right, Math.max(up, down));
        }
    }

    // Find the maximum value in the first column (starting column)
    int max = dp[0][0];
    for (int i = 1; i < n; i++) {
        max = Math.max(max, dp[i][0]);
    }

    return max;
}
}
