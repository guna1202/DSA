import java.util.Scanner;

public class Solution {

  //recursion with memoization pass dp array when calling
  public static boolean recursion(int n, int[] arr, int sum, int i, Boolean[][] dp) {
    if (sum > 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024))
      return true;

    if (i >= n)
      return false;

    if (dp[i][sum] != null)
      return dp[i][sum];

    return dp[i][sum] = recursion(n, arr, sum + arr[i], i + 1, dp) | recursion(n, arr, sum, i + 1, dp);
  }

  //tabulation with space optimization
  public static boolean isPossibleTabulation(int N, int[] coins) {
        // code here
        boolean prev[] = new boolean[2025];
        boolean curr[] = new boolean[2025];
        prev[0] = true;

        for (int sum = 1; sum < 2025; sum++) {
            prev[sum] = false;
        }

        for (int i = 1; i <= N; i++) {
            curr[0] = true;
            for (int sum = 1; sum < 2025; sum++) {
                curr[sum] = prev[sum];
                if (sum >= coins[i - 1]) {
                    curr[sum] |= prev[sum - coins[i - 1]];
                }

                if (i == N) {
                    if ((sum % 20 == 0 || sum % 24 == 0 || sum == 2024) && curr[sum]) {
                        return true;
                    }
                }
            }
            prev = curr.clone();
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of coins
        System.out.print("Enter the number of coins: ");
        int N = scanner.nextInt();

        // Input the values of coins
        int[] coins = new int[N];
        System.out.println("Enter the values of coins:");
        for (int i = 0; i < N; i++) {
            coins[i] = scanner.nextInt();
        }

        // Call the function and display the result
        boolean result = isPossibleTabulation(N, coins);
        System.out.println("Can we get 2024? " + result);
    }
}
