import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DirectedGraph<T> {
    private HashMap<T,ArrayList<T>> nodes;
    DirectedGraph(){
        nodes=new HashMap<T,ArrayList<T>>();
    }
    public void addVertex(T V){
        nodes.put(V,new ArrayList<T>());
    }
    public void addEdge(T u,T v){
        nodes.get(u).add(v);
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
}