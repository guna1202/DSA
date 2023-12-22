import java.util.Scanner;

public class GameOfXOR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size : ");
    int N = sc.nextInt();

    int num[] = new int[N];

    System.out.println("Enter the array elements");
    for (int i = 0; i < N; i++) {
      num[i] = sc.nextInt();
    }

    int xor = gameOfXor(N, num)
  }

  public static int gameOfXor(int N , int[] A) {
    if(N % 2 == 0) return 0;
    
    int xor = 0;
    
    for(int i = 0 ; i < N; i++){
        if(i % 2 == 0){
            xor ^= A[i];
        }
    }
    return xor;
}
}
