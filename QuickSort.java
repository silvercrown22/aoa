import java.util.*;

public class QuickSort{
    
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    
    static int partition(int[] arr, int l, int h){
        int pivot = arr[l];
        int i = l;
        int j = h;

        while(i<j){

            while(arr[i]<=pivot && i<=h-1) i++;
            while(arr[j]>pivot && j>=l) j--;
            
            if(i<j  ){
                swap(arr,i,j);
            }
        
        }


        swap(arr,l,j);
        
        return j;
    }

    static void quickSort(int[] arr,int l, int h){
        if(l<h){        
            int pivot = partition(arr,l,h);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,h);
        }
    }
    
    public static void main(String[] args){
       int[] arr = new int[]{5,1,6,2,3,3,10,20,15,13};
       quickSort(arr,0,arr.length-1);
       System.out.println(Arrays.toString(arr));
    }

    
}
