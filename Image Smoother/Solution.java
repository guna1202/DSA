import java.util.Scanner;

public class Solution {
  public int[][] imageSmoother(int[][] img) {
    int res[][] = new int[img.length][img[0].length];
    for(int i = 0; i < img.length; i++) {
        for(int j = 0; j < img[0].length; j++) {
            res[i][j] = smoothen(img, i, j);
        }
    }
    return res;
}

  int smoothen(int[][] img, int x, int y) {
      int m = img.length; 
      int n = img[0].length;
      int sum = 0;
      int count = 0;
      for(int i = -1; i <= 1; i++) {
          for(int j = -1; j <= 1; j++) {
              int nx = x + i;
              int ny = y + j;
              if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
              sum += img[nx][ny];
              count++;
          }
      }
      return sum/count;
  }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter the number of rows in the image: ");
      int m = scanner.nextInt();
      System.out.print("Enter the number of columns in the image: ");
      int n = scanner.nextInt();

      int[][] img = new int[m][n];

      System.out.println("Enter the elements of the image:");
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              img[i][j] = scanner.nextInt();
          }
      }

      Solution solution = new Solution();
      int[][] result = solution.imageSmoother(img);

      System.out.println("Smoother Image:");
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              System.out.print(result[i][j] + " ");
          }
          System.out.println();
      }

      scanner.close();
  }
}
