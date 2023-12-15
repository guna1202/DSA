public class ClimbingStairs {
  public static void main(String[] args) {
    int n = 20;
    int ans = nthPoint(n);System.out.println(ans);
  }

  public static int nthPoint(int n){
        int a = 1;
        int b = 1;
        int mod = (int) 1e9 + 7;
        
        for(int i = 1; i < n; i++){
            int c = (a + b) % mod;
            
            a = b;
            b = c;
        }
        
        return b;
    }
}
