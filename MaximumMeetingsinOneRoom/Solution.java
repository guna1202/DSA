import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] start = new int[n];
        System.out.println("Enter the start time of the meetings:");

        for (int i = 0; i < n; i++) {
          start[i] = scanner.nextInt();
        }
        
        int[] end = new int[n];
        System.out.println("Enter the end time of the meetings:");

        for (int i = 0; i < n; i++) {
          end[i] = scanner.nextInt();
        }
        
        List<Integer> al = maxMeetings(n, start, end);
  }

  public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
         ArrayList<Integer> list = new ArrayList<>();
        int[][] meeting = new int[N][3];
        for(int i=0; i<N; i++){
            meeting[i][0] = i;
            meeting[i][1] = S[i];
            meeting[i][2] = F[i];
        }
        Arrays.sort(meeting, Comparator.comparingDouble(o -> o[2]));
        list.add(meeting[0][0]+1);
        int lastEndTime = meeting[0][2];
        for(int i=1; i<N; i++){
            if(meeting[i][1] > lastEndTime){
                list.add(meeting[i][0]+1);
                lastEndTime = meeting[i][2];
            }
        }
        Collections.sort(list);
        return list;
    }
}
