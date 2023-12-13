import java.util.Scanner;

public class Consecutive1sNotAllowed {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long count = countStrings(n);
  }

  public static long countStrings(int n) {
    // code here
    long arr0[] = new long[n + 1];
    long arr1[] = new long[n + 1];
    
    int mod = (int)1e9 + 7;
    
    arr0[0] = arr1[0] = 0;
    arr0[1] = arr1[1] = 1;
    
    for(int i = 2; i <= n; i++){
        arr0[i] = arr0[i - 1] + arr1[i - 1] % mod;
        arr1[i] = arr0[i - 1];
    }
    
    return (arr0[n] + arr1[n]) % mod;
 }
}
