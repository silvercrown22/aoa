import java.util.*;

public class MergeSort{

    static void merge(int[] arr, int l, int mid, int r){
        int[] t = new int[r+1];
        int i = l;
        int j = mid+1;
        int k = l;

        while(i<=mid && j<=r){
            if(arr[i]>arr[j]){
                t[k] = arr[j];
                j++;
            }
            else{
                t[k] = arr[i];
                i++;
            }
            k++;
        }

        
        // Check which pointer got exhausted        
        if(i>mid){
            // i was exhausted
            while(j<=r){
                t[k] = arr[j];
                j++;
                k++;
            }
        }
        else{
            // j was exhausted
            while(i<=mid){
                t[k] = arr[i];
                i++;
                k++;
            }
        }


        // Copy t array to arr array
        for(int m=l;m<=r;m++){
            arr[m] = t[m];
        }
        
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }


    public static void main(String[] args){
        int[] arr = new int[]{5,4,3,2,1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
