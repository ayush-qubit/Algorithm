import java.util.ArrayList;
import java.util.Scanner;

public class GraphsTutorial{
    public static class Node{
        int data;
        ArrayList<Node> adjcNodes;
        Node(int data){
            this.data=data;
            adjcNodes=new ArrayList<Node>();
        }
    }
    public static void initGraph(Node[] nodes,int V){
        for(int i=0;i<V;i++){
            nodes[i]=new Node(i+1);
        }
    }
    public static void addEdge(Node[] nodes,int u,int v){
        nodes[u-1].adjcNodes.add(nodes[v-1]);
    }
    public static void printGraph(Node[] nodes){
        int V=nodes.length;
        for(int i=0;i<V;i++){
            System.out.print((i+1)+": ");
            for(int j=0;j<nodes[i].adjcNodes.size();j++){
                System.out.print(nodes[i].adjcNodes.get(j).data+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=4;
        Node[] nodes=new Node[V];
        initGraph(nodes,V);
        System.out.println("Graph initialized...");
        addEdge(nodes,1,2);
        addEdge(nodes,1,4);
        addEdge(nodes,2,3);
        addEdge(nodes,3,1);
        printGraph(nodes);
        sc.close();
    }
}