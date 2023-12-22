import java.util.Scanner;

public class Consecutive1sNotAllowed {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long count = countStrings(n);
  }

  public static long countStrings(int n) {
    // code here
    int mod = (int) 1e9 + 7;
        
        long fillZero = 1;
        long fillOne = 1;
        long total = 2;
    
        for (int i = 2; i <= n; i++) {
            fillOne = fillZero;
            fillZero = total;
            total = (fillOne + fillZero) % mod;
        }
        
        return total;
 }
}
