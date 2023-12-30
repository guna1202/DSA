import java.util.Scanner;

public class Solution {
   //recursion approach with memoization 
   static int recursion(char[] wild, int i, char[] pattern, int j, int[][] dp) {
       if (i < 0 && j < 0)
           return 1;
       if (j >= 0 && i < 0)
           return 0;
       if (j < 0 && i >= 0) {
           for (int ii = 0; ii <= i; ii++) {
               if (wild[ii] != '*')
                   return 0;
           }
           return 1;
       }
       if (dp[i][j] != -1)
           return dp[i][j];

       if (wild[i] == pattern[j] || wild[i] == '?')
           return dp[i][j] = recursion(wild, i - 1, pattern, j - 1, dp);
       if (wild[i] == '*')
           return dp[i][j] = recursion(wild, i - 1, pattern, j, dp) | recursion(wild, i, pattern, j - 1, dp)
                   | recursion(wild, i - 1, pattern, j - 1, dp);

       return dp[i][j] = 0;
   }
    
   //tabulation approach without space optimization
   static boolean matchTabulation(String wild, String pattern) {
       int m = wild.length();
       int n = pattern.length();
       boolean[][] dp = new boolean[m + 1][n + 1];

       dp[0][0] = true;

       for (int j = 1; j <= n; j++) {
           dp[0][j] = false;
       }

       for (int i = 1; i <= m; i++) {
           boolean flag = true;
           for (int ii = 1; ii <= i; ii++) {
               if (wild.charAt(ii - 1) != '*') {
                   flag = false;
               }
           }
           dp[i][0] = flag;
       }

       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               if (wild.charAt(i - 1) == pattern.charAt(j - 1) || wild.charAt(i - 1) == '?') {
                   dp[i][j] = dp[i - 1][j - 1];
               } else if (wild.charAt(i - 1) == '*') {
                   dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
               } else {
                   dp[i][j] = false;
               }
           }
       }

       return dp[m][n];
   }
     
     //tabulation approach with space optimization 
   static boolean match(String wild, String pattern){
        int m = wild.length();
        int n = pattern.length();
        boolean[] prev = new boolean[n+1];
        boolean[] cur = new boolean[n+1];
        
        prev[0] = true;
        
        for(int j = 1; j <= n; j++){
            prev[j] = false;
        }
        
        
        for(int i = 1; i <= m; i++){
            
            boolean flag = true;
            for(int ii = 1; ii <= i; ii++){
                if(wild.charAt(ii-1) != '*'){
                    flag = false;
                }
            }
            cur[0] = flag;
            
            for(int j = 1; j <= n; j++){
                if(wild.charAt(i-1) == pattern.charAt(j-1) || wild.charAt(i-1) == '?'){
                    cur[j] = prev[j-1];
                }
                else if(wild.charAt(i-1) == '*'){
                    cur[j] = prev[j] || cur[j-1];
                }
                else{
                    cur[j] = false;
                }
            }
            prev = cur.clone();
        }
        
        return prev[n];
    }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the wild string:");
    String wild = scanner.nextLine();

    System.out.println("Enter the pattern string:");
    String pattern = scanner.nextLine();

    boolean result = match(wild, pattern);

    System.out.println("Result: " + result);
  }
  
}