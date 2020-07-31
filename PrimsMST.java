import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class PrimsMST {
    private HashMap<String,String> parent;
    private BinaryMinHeap<String> minHeap;
    PrimsMST(){
        parent=new HashMap<String,String>();
        minHeap=new BinaryMinHeap<String>();
    }
    private void RELAX(Graph<String> graph,String u,String v){
        int w=graph.getEdgeWeight(u,v);
        if(w<minHeap.getWeight(v)){
            minHeap.decrease(v,w);
            parent.replace(v,u);
        }
    }
    public void MST(Graph<String> graph){
        ArrayList<String> vertices=graph.getVertices();
        String source=vertices.get(0);
        for(int i=0;i<vertices.size();i++){
            minHeap.add(Integer.MAX_VALUE,vertices.get(i));
            parent.put(vertices.get(i), null);
        }
        minHeap.decrease(source,0);
        String vertex;
        ArrayList<String> adj;
        while(!minHeap.empty()){
            vertex=minHeap.extractMin();
            adj=graph.getAdjacentNodes(vertex);
            for(int i=0;i<adj.size();i++){
                if(minHeap.containsData(adj.get(i))){
                    RELAX(graph,vertex,adj.get(i));     
                }
            }
        }
        System.out.println();
        Set<Entry<String,String>> s=parent.entrySet();
        Iterator<Entry<String,String>> i=s.iterator();
        System.out.println("Edges in MST are: ");
        while(i.hasNext()){
            Entry<String,String> e=i.next();
            System.out.println(e.getValue()+" "+e.getKey());
        }
    }
    public static void main(String[] args) {
        Graph<String> g=new Graph<String>();
        String[] strs={"A","B","C","D"};
        for(int i=0;i<strs.length;i++){
            g.addVertex(strs[i]);
        }
        g.addEdge("A", "B");
        g.setEdgeWeight("A", "B", 1);
        g.addEdge("A", "D");
        g.setEdgeWeight("A", "D", 3);
        g.addEdge("B", "D");
        g.setEdgeWeight("B", "D", 3);
        g.addEdge("B", "C");
        g.setEdgeWeight("B", "C", 1);
        g.addEdge("D", "C");
        g.setEdgeWeight("D", "C", 1);
        PrimsMST prim=new PrimsMST();
        prim.MST(g);
    }
}