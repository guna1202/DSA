import java.util.Scanner;

public class MaximumSumOfNonAdjacentElements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size : ");
    int N = sc.nextInt();

    int arr[] = new int[N];

    System.out.println("Enter the array elements");
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int result = findMaxSum(arr, N);
  }
  
  private static int findMaxSum(int[] arr, int n) {
    int prev1 = arr[0];
        int prev2 = 0;
        
        for(int i =  1; i < n; i++){
            int pick = arr[i];
            if(i > 1){
                pick += prev2;
            }
            int notPick = 0 + prev1;
            
            int curr = Math.max(pick, notPick);
            
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
  }

  
  static int findMaxSumRecursion(int arr[], int n) {
    int dp[] = new int[n];

    for (int i = 0; i < n; i++) {
      dp[i] = -1;
    }

    int ans = recursion(arr, n - 1, dp);
    return ans;
  }
  
  static int recursion(int[] arr, int i, int[] dp){
    if(i == 0) return arr[i];
    if(i < 0) return 0;
    if(dp[i] != -1) return dp[i];
    
    int pick = arr[i] + recursion(arr, i - 2, dp);
    int notpick = 0 + recursion(arr, i - 1, dp);
    
    return dp[i] = Math.max(pick, notpick);
  }
}
