import java.util.*;

public class BellmanFord{
        
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter no of vertex: ");
        int noOfVertex = scan.nextInt();
        System.out.print("Enter no of edges: ");
        int no = scan.nextInt();
        System.out.print("Enter source: ");
        int src = scan.nextInt();


        int[][] edges = new int[no][3];

        for(int i=0;i<no;i++){
            System.out.println("Edge "+(i+1));
            System.out.print("Enter source, distance, destination: ");
            edges[i][0] = scan.nextInt();
            edges[i][1] = scan.nextInt();
            edges[i][2] = scan.nextInt();
        }



        int[] dist = new int[noOfVertex];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        
        for(int count = 1 ; count < noOfVertex ; count++){
            for (int[] e : edges){
                int source = e[0];
                int wt = e[1];
                int dest = e[2];
                if(dist[source] != Integer.MAX_VALUE && (dist[source] + wt) < dist[dest]){
                    dist[dest] = dist[source] + wt;
                }               
            }

        }

        boolean negativeEdge = false;
        
        for (int[] e : edges){
                int source = e[0];
                int wt = e[1];
                int dest = e[2];
                if(dist[source] != Integer.MAX_VALUE && (dist[source] + wt) < dist[dest]){
                   negativeEdge = true;
                }               
        }   
        
        
        if(negativeEdge==true){
            System.out.println("Negayive Cycle present");
        }
        else{
            System.out.println(Arrays.toString(dist));
        }

    }
    
}
