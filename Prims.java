import java.util.*;
public class Prims{

    static class Pair implements Comparable<Pair>{
        int v;
        int w;

        Pair(int v,int w){
            this.v = v;
            this.w = w;
        }

        public int compareTo(Pair p){
            return this.w - p.w;
        }
    }
    
    public static void main(String[] args){
        // Creating Adjacent List

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<Integer>(Arrays.asList(1,1)));
        a.add(new ArrayList<Integer>(Arrays.asList(4,5)));

        ArrayList<ArrayList<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<Integer>(Arrays.asList(0,1)));
        b.add(new ArrayList<Integer>(Arrays.asList(2,2)));

        ArrayList<ArrayList<Integer>> c = new ArrayList<>();
        c.add(new ArrayList<Integer>(Arrays.asList(1,2)));
        c.add(new ArrayList<Integer>(Arrays.asList(4,6)));
        c.add(new ArrayList<Integer>(Arrays.asList(3,3)));

        ArrayList<ArrayList<Integer>> d = new ArrayList<>();
        d.add(new ArrayList<Integer>(Arrays.asList(2,3)));
        d.add(new ArrayList<Integer>(Arrays.asList(4,4)));

        ArrayList<ArrayList<Integer>> e = new ArrayList<>();
        e.add(new ArrayList<Integer>(Arrays.asList(0,5)));
        e.add(new ArrayList<Integer>(Arrays.asList(2,6)));
        e.add(new ArrayList<Integer>(Arrays.asList(3,4)));

        adj.add(a);
        adj.add(b);
        adj.add(c);
        adj.add(d);
        adj.add(e);

        
        PriorityQueue<Pair> q = new PriorityQueue<Pair>();
        boolean[] visited = new boolean[adj.size()];
        q.add(new Pair(0,0));

        int ans = 0;

        while(q.size()>0){
            Pair curr = q.remove();
            
            if(visited[curr.v]) continue;
            ans += curr.w;
            System.out.print(curr.v+" => ");
            visited[curr.v] = true;
            
            ArrayList<ArrayList<Integer>> neighbours = adj.get(curr.v);
            
            for(ArrayList<Integer> neighbour:neighbours){
                if(!visited[neighbour.get(0)]) q.add(new Pair(neighbour.get(0),neighbour.get(1)));
            }
            
        }

        System.out.println("end\n"+ans);
        
    }
}
