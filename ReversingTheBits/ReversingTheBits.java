package ReversingTheBits;
import java.util.Scanner;

public class ReversingTheBits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = 12;
    long reversedDigits = reverseBit(a);
    System.out.println(reversedDigits);
  }

  private static long reverseBit(long a) {
    long reverseNumber = 0;

    for (int i = 0; i < 32; i++) {
      if ((a & (1L << i)) != 0) {
        reverseNumber |= (1L << 31-i);
      }
    }
    
    return reverseNumber;
  }
}
