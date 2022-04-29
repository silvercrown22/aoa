import java.util.*;
public class FractionalKnapsack{

    public static double getMaxValue(int capacity, int[] value, int[] weight){
        Item[] items = new Item[value.length];
        
        for(int i=0; i<value.length; i++){
            items[i] = new Item(value[i],weight[i]);
        }        
        
        Arrays.sort(items);
        

        double totalValue=0;

        for(Item item:items){
            if((capacity-item.weight)>=0){
                totalValue += item.value;
                capacity -= item.weight;
            }
            else{
                double frac = (double)capacity/item.weight;
                totalValue += frac*item.value;
                break;
            }
        }
        
        return totalValue;
    }
    
    static class Item implements Comparable<Item>{
        int value;
        int weight;
        double ratio;
        
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.ratio = (double)value/weight;        
        }

        public int compareTo(Item o){
            if(this.ratio<o.ratio) return 1;
            else if(this.ratio > o.ratio) return -1;            
            else return 0;
        }
        
    }

    public static void main(String[] args){
        int[] wt = {10, 40, 20, 30};
        int[] val = {60, 40, 100, 120};
        int capacity = 50;
        

        double max = getMaxValue(capacity,val,wt);

        System.out.println(max);
        
    }

}
