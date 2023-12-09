import java.util.Scanner;

public class ReversingTheBits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long a = 11;
    long reversedDigits = reverseBit(a);
    System.out.println(reversedDigits);
  }

  private static long reverseBit(long a) {
    long reversedBit = 0;
    int first = 0;
    int last = 0;

    for (int i = 31; i >= 0; i--) {
      if ((a & (1 << i)) > 0) {
        first = i;
        break;
      }
    }

    while (first >= last) {
      if ((a & (1 << first)) > 0) {
        reversedBit = reversedBit | (1 << last);
      }
      
      if ((a & (1 << last)) > 0) {
        reversedBit = reversedBit | (1 << first);
      }

      first--;
      last++;
    }
    
    return reversedBit;
  }
}
