import java.util.Scanner;

public class SpecialPositionsInABinaryMatrix {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (m): ");
    int m = scanner.nextInt();

    System.out.print("Enter the number of columns (n): ");
    int n = scanner.nextInt();

    int[][] mat = new int[m][n];

    System.out.println("Enter the elements of the matrix (0 or 1):");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        mat[i][j] = scanner.nextInt();
      }
    }

    int specialPositionCount = numSpecial(mat);
    System.out.println(specialPositionCount);
  }
  
  public static int numSpecial(int[][] mat) {
    int m = mat[0].length;
    int n = mat.length;

    int rowSum[] = new int[n];
    int colSum[]= new int[m];

    for(int i = 0 ; i < n; i++){
        for(int j = 0 ; j < m; j++){
            rowSum[i] += mat[i][j];
            colSum[j] += mat[i][j];  
        }
    }

    int count = 0;
    
    for(int i = 0; i < n; i++){
        for(int j=  0; j < m; j++){
            if(mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1){
                count++;
            }
        }
    }

    return count;
}
}
