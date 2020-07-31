import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSorting {
    private Stack<String> stack;
    private HashMap<String,Integer> isVisited;
    TopologicalSorting(){
        stack=new Stack<String>();
    }
    public void TopologicalSort(DirectedGraph<String> G){
        ArrayList<String> vertices=G.getVertices();
        DFS(G,vertices);
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
    private void traverse(DirectedGraph<String> G,String vertex){
        ArrayList<String> adj=G.getAdjacentNodes(vertex);
        if(adj.isEmpty()){
            return;
        }
        else{
            for(int i=0;i<adj.size();i++){
                String node=adj.get(i);
                if(isVisited.get(node)==0){
                    isVisited.put(node,1);
                    traverse(G,node);
                    isVisited.put(node,2);
                    stack.push(node);
                }
            }
        }
    }
    private void DFS(DirectedGraph<String> G,ArrayList<String> vertices){
        isVisited=new HashMap<String,Integer>();
        for(int i=0;i<vertices.size();i++){
            isVisited.put(vertices.get(i), 0);
        }
        for(int i=0;i<vertices.size();i++){
            if(isVisited.get(vertices.get(i))==0){
                isVisited.put(vertices.get(i),1);
                traverse(G,vertices.get(i));
                isVisited.put(vertices.get(i),2);
                stack.push(vertices.get(i));
            }
        }
    }
    public static void main(String[] args) {
        DirectedGraph<String> g=new DirectedGraph<String>();
        String[] strs={"A","B","C","D","E","F","G","H"};
        for(int i=0;i<strs.length;i++){
            g.addVertex(strs[i]);
        }
        g.addEdge("A","C");
        g.addEdge("B","C");
        g.addEdge("B","D");
        g.addEdge("C","E");
        g.addEdge("D","F");
        g.addEdge("E","H");
        g.addEdge("E","F");
        g.addEdge("F","G");
        TopologicalSorting TS=new TopologicalSorting();
        TS.TopologicalSort(g);
    }
}