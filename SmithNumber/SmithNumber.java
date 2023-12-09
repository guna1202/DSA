public class SmithNumber {
  public static void main(String[] args){
    int n = 4;
    if(isSmithNumber(n)) System.out.println(n +" is a Smith Number!");
    else System.out.println(n +" is not a Smith Number!");
  }

  private static boolean isSmithNumber(int n) {
    if (isPrime(n))
      return false;

    int primeFactorSum = primeFactorsSum(n);
    int digitSum = digitsSum(n);
     
    return (primeFactorSum == digitSum);
  }

  private static int digitsSum(int n) {
    int sum = 0;
    int temp = n;
    while (temp > 0) {
      sum +=  (temp % 10);
      temp /= 10; 
    }
    return sum;
  }

  private static int primeFactorsSum(int n) {
    int sum = 0;
    int i = 2;

    while (i <= n) {
      if (isPrime(i) && n % i == 0) {
        sum += digitsSum(i);
        n /= i;
      } else {
        i++;
      }
    }
    
    // if (isPrime(n)) {
    //   sum += digitsSum(n);
    // }
  
    return sum;
  }

  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
  
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}
