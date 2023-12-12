import java.util.ArrayList;

public class PascalTriangle {
  public static void main(String args[]) {
    int row = 5;
    int col = 3;

    ArrayList<Long> al = rowElements(row);
    int element = singleElement(row, col);
    printArray(al);
    System.out.println(element + " is in the place of " + col + " in " + row);
  }

  private static void printArray(ArrayList<Long> al) {
    for (Long i : al) {
      System.out.print(i + " ");
    }
  }

  private static int singleElement(int row, int col) {
    int element = 1;

    for (int i = 1; i <= col - 1; i++) {
      element = element * --row;
      element = element / i;
    }
    return element;
  }

  private static ArrayList<Long> rowElements(int row) {
    ArrayList<Long> al = new ArrayList<>();
    long element = 1;
    al.add(element);

    for (int col = 1; col < row; col++) {
      element = element * (row - col);
      element = element / col;
      al.add(element);
    }
    
    return al;
  }
}
