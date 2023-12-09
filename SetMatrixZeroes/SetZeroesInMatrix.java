public class SetZeroesInMatrix {

  public static void main(String[] args) {
      SetZeroesInMatrix solution = new SetZeroesInMatrix();

      int[][] matrix = {
          {1, 2, 3},
          {4, 0, 6},
          {7, 8, 9}
      };

      System.out.println("Original Matrix:");
      solution.printMatrix(matrix);

      solution.setZeroes(matrix);

      System.out.println("Matrix after setting zeroes:");
      solution.printMatrix(matrix);
  }

  public void setZeroes(int[][] matrix) {
      int n = matrix.length;
      int m = matrix[0].length;

      boolean col0 = false;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              if (matrix[i][j] == 0) {
                  matrix[i][0] = 0;
                  if (j != 0) {
                      matrix[0][j] = 0;
                  } else {
                      col0 = true;
                  }
              }
          }
      }

      for (int i = 1; i < n; i++) {
          for (int j = 1; j < m; j++) {
              if (matrix[i][j] != 0) {
                  if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                      matrix[i][j] = 0;
                  }
              }
          }
      }

      if (matrix[0][0] == 0) {
          for (int j = 0; j < m; j++) {
              matrix[0][j] = 0;
          }
      }

      if (col0) {
          for (int i = 0; i < n; i++) {
              matrix[i][0] = 0;
          }
      }
  }

  public void printMatrix(int[][] matrix) {
      int n = matrix.length;
      int m = matrix[0].length;

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
      }
      System.out.println();
  }
}
