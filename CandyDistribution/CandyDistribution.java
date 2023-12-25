import java.util.Scanner;

public class CandyDistribution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size : ");
    int N = sc.nextInt();

    int arr[] = new int[N];

    System.out.println("Enter the array elements");
    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    int requiredCandy = minCandy(N, arr);
    System.out.println(requiredCandy);
  }

  static int minCandy(int N, int ratings[]) {
    int[] leftToRight = new int[N];
    // int[] rightToLeft = new int[N];
    leftToRight[0] = 1;
    // rightToLeft[N-1] = 1;
    int right = 1;
    
    for(int i = 1; i < N; i++) {
        if(ratings[i] > ratings[i-1]) leftToRight[i] = leftToRight[i-1]+1;
        else leftToRight[i] = 1;
    }
    
    int total = Math.max(leftToRight[N-1], right);
    
    for(int i = N-2; i >= 0; i--) {
        if(ratings[i] > ratings[i + 1]){
            right++;
        }else{
            right = 1;
        }
        total += Math.max(leftToRight[i], right);
    }
    
    return total;
}
}
