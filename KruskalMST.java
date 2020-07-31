import java.util.ArrayList;

public class KruskalMST {
    private DisjointSet<String> set;
    private BinaryMinHeap<String> minHeap;
    KruskalMST(){
        set=new DisjointSet<String>();
        minHeap=new BinaryMinHeap<String>();
    }
    public void MST(Graph<String> graph){
        ArrayList<ArrayList<String>> edges=graph.getEdges();
        for(int i=0;i<edges.size();i++){
            int weight=graph.getEdgeWeight(edges.get(i).get(0), edges.get(i).get(1));
            String key=edges.get(i).get(0)+edges.get(i).get(1);
            minHeap.add(weight, key);
        }
        ArrayList<String> vertices=graph.getVertices();
        for(String v: vertices){
            set.makeset(v);
        }
        ArrayList<String> result=new ArrayList<String>();
        while(!minHeap.empty()){
            String edge=minHeap.extractMin();
            String u=edge.substring(0,1);
            String v=edge.substring(1);
            if(set.findset(u)!=set.findset(v)){
                set.union(u, v);
                result.add(u+v);
            }
        }
        for(String e:result){
            System.out.println(e);
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
        g.setEdgeWeight("B", "C", 3);
        g.addEdge("C", "D");
        g.setEdgeWeight("C", "D", 1);
        KruskalMST mst=new KruskalMST();
        mst.MST(g);
    }
}