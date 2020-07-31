//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Graph<T>{
    private HashMap<T,ArrayList<T>> nodes;
    private HashMap<T,HashMap<T,Integer>> edgeWeight;
    Graph(){
        nodes=new HashMap<T,ArrayList<T>>();
        edgeWeight=new HashMap<T,HashMap<T,Integer>>();
    }
    public void addVertex(T V){
        nodes.put(V,new ArrayList<T>());
        edgeWeight.put(V,new HashMap<T,Integer>());
    }
    public void addEdge(T u,T v){
        nodes.get(u).add(v);
        nodes.get(v).add(u);
        setEdgeWeight(u, v, 0);
    }
    public void setEdgeWeight(T u,T v,int weight){
        edgeWeight.get(u).put(v,weight);
        edgeWeight.get(v).put(u,weight);
    }
    public int getEdgeWeight(T u,T v){
        return edgeWeight.get(u).get(v);
    }
    public ArrayList<T> getAdjacentNodes(T vertex){
        return nodes.get(vertex);
    }
    public void printGraph(){
        Set<T> vertices=nodes.keySet();
        Iterator<T> i=vertices.iterator();
        while(i.hasNext()){
            T a=i.next();
            System.out.print(a+": ");
            for(int j=0;j<nodes.get(a).size();j++){
                System.out.print(nodes.get(a).get(j)+" ");
            }
            System.out.println();
        }
    }
    public ArrayList<T> getVertices(){
        Set<T> s=nodes.keySet();
        Iterator<T> i=s.iterator();
        ArrayList<T> vertices=new ArrayList<T>();
        while(i.hasNext()){
            vertices.add(i.next());
        }
        return vertices;
    }
    public ArrayList<ArrayList<T>> getEdges(){
        ArrayList<T> vertices=getVertices();
        HashMap<T,Integer> map=new HashMap<T,Integer>();
        for(int i=0;i<vertices.size();i++){
            map.put(vertices.get(i), 0);
        }
        ArrayList<ArrayList<T>> edges=new ArrayList<ArrayList<T>>();
        for(int i=0;i<vertices.size();i++){
            ArrayList<T> adj=getAdjacentNodes(vertices.get(i));
            for(int j=0;j<adj.size();j++){
                if(map.containsKey(adj.get(j))){
                    ArrayList<T> temp=new ArrayList<T>();
                    temp.add(vertices.get(i));
                    temp.add(adj.get(j));
                    edges.add(temp);
                }
            }
            map.remove(vertices.get(i));
        }
        return edges;
    }
    /*public static void main(String[] args) {
        Graph<String> g=new Graph<String>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        g.printGraph();
    }*/
}