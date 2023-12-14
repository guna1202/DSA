import java.util.Scanner;

public class DifferenceBetweenOnesandZerosinRowandColumn {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of rows (n): ");
    int n = scanner.nextInt();

    System.out.print("Enter the number of columns (m): ");
    int m = scanner.nextInt();

    int[][] grid = new int[n][m];

    System.out.println("Enter the elements of the grid (0 or 1):");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            grid[i][j] = scanner.nextInt();
        }
    }

    // Call the onesMinusZeros method
    int[][] result = onesMinusZeros(grid);

    // Display the result
    System.out.println("Resulting grid:");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            System.out.print(result[i][j] + " ");
        }
        System.out.println();
    }

    // Close the scanner
    scanner.close();
}

public static int[][] onesMinusZeros(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int row1[] = new int[n];
    int col1[] = new int[m];

    int row0[] = new int[n];
    int col0[] = new int[m];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            if(grid[i][j] == 1){
                row1[i]++;
                col1[j]++;
            }else{
                row0[i]++;
                col0[j]++;
            }
        }
    }

    int[][] diff = new int[n][m];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            diff[i][j] = row1[i] + col1[j] - row0[i] - col0[j];
        }
    }

    return diff;
}
}
