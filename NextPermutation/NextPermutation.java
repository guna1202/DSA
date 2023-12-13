import java.util.ArrayList;
import java.util.List;

public class NextPermutation {
  public static void main(String[] args) {
    int N = 6;
    int[] arr = { 1, 2, 3, 6, 5, 4 };

    System.out.println("Original Array: ");
    printArray(arr);

    List<Integer> result = nextPermutation(N, arr);

    System.out.println("After Next Permutation: ");
    printList(result);
  }
  
  public static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int ind = -1;
        
        for(int i = N - 2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                ind = i;
                break;
            }
        }
        
        if(ind == -1){
            reverseArray(arr, 0, N - 1);
        }else{
            
            for(int i = N - 1; i >= 0; i--){
                if(arr[i] > arr[ind]){
                    swapElements(arr, i , ind);
                    break;
                }
            }
            
            reverseArray(arr, ind + 1, N - 1);
        }
        
        
        List<Integer> al = new ArrayList<>();
        
        for(int i : arr){
            al.add(i);
        }
        
        return al;
    }
    
    public static void reverseArray(int[] arr, int start, int end){
        while(start < end){
            swapElements(arr, start, end);
            start++;
            end--;
        }
    }
    
    public static void swapElements(int[] arr, int i, int ind) {
      int temp = arr[i];
      arr[i] = arr[ind];
      arr[ind] = temp;
    }
    
    public static void printArray(int[] arr) {
      for (int num : arr) {
          System.out.print(num + " ");
      }
      System.out.println();
  }

  public static void printList(List<Integer> list) {
      for (int num : list) {
          System.out.print(num + " ");
      }
      System.out.println();
  }
}
