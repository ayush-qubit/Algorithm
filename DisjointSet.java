import java.util.HashMap;

public class DisjointSet<T>{
    private class Node{
        T data;
        int rank;
        Node parent;
        Node(T data){
            this.data=data;
            parent=this;
            rank=0;
        }
    }
    HashMap<T,Node> nodes;
    DisjointSet(){
        nodes=new HashMap<T,Node>();
    }
    public void makeset(T data){
        nodes.put(data,new Node(data));
    }
    private Node findset(Node node){
        Node parent=node.parent;
        if(parent==node){
            return node;
        }
        node.parent=findset(parent);
        return node.parent;
    }
    public T findset(T data){
        return findset(nodes.get(data)).data;
    }
    public void union(T data1,T data2){
        Node node1=nodes.get(data1);
        Node node2=nodes.get(data2);
        Node parent1=findset(node1);
        Node parent2=findset(node2);
        if(parent1.data==parent2.data){
            return;
        }
        if(parent1.rank>=parent2.rank){
            parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
            parent2.parent=parent1;
        }
        else{
            parent1.parent=parent2;
        }
    }
    /*public static void main(String[] args) {
        DisjointSet<Integer> set=new DisjointSet<Integer>();
        set.makeset(1);
        set.makeset(2);
        set.makeset(3);
        set.makeset(4);
        set.makeset(5);
        set.union(1, 2);
        set.union(3, 4);
        set.union(4, 5);
        set.union(2, 5);
        System.out.println(set.findset(4));
        System.out.println(set.findset(2));
        System.out.println(set.findset(4));
        System.out.println(set.findset(5));
    }*/
}