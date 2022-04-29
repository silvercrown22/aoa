import java.util.*;
public class Selection{
    
    static void selection(int[] arr){
        for(int i=0 ; i<arr.length ; i++){
            int min_idx = i;
            for(int j=i+1 ; j<arr.length ; j++){
                if(arr[j]<arr[min_idx]){
                    min_idx = j;
                }
            
            }
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }
  
    public static void main(String[] args){
        Scanner scan  = new Scanner(System.in);
        System.out.print("Enter no of element: ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            System.out.print("Enter elements: ");
            arr[i] = scan.nextInt();
        }        

        selection(arr);
        
        System.out.println(Arrays.toString(arr));

    }
}
