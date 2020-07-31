import java.math.BigDecimal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianUpdates {
    public static void balance(PriorityQueue<Integer> maxQueue,PriorityQueue<Integer> minQueue){
        int diff=maxQueue.size()-minQueue.size();
        if(diff>1){
            minQueue.add(maxQueue.remove());
        }
        else if(diff<=-1){
            maxQueue.add(minQueue.remove());
        }
    }
    public static String getMedian(PriorityQueue<Integer> maxQueue,PriorityQueue<Integer> minQueue){
        String median;
        if(maxQueue.isEmpty()){
            return "Wrong!";
        }
        if(maxQueue.size()==minQueue.size()){
            int a=maxQueue.element();
            int b=minQueue.element();
            BigDecimal bDecimal=new BigDecimal(a/2.0 + b/2.0);
            return bDecimal.toString();
        }
        else{
            median=Integer.toString(maxQueue.element());
        }
        return median;
    }
    public static void findMedian(String s[],int[] x){
        int n=s.length;
        PriorityQueue<Integer> maxQueue=new PriorityQueue<Integer>(1,new Comparator<Integer>(){
            public int compare(Integer I1,Integer I2){
                if(I1.intValue()>I2.intValue()){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        PriorityQueue<Integer> minQueue=new PriorityQueue<Integer>();
        for(int i=0;i<n;i++){
            char a=s[i].charAt(0);
            int b=x[i];
            if(a=='r'){
                if(!maxQueue.isEmpty() && b<=maxQueue.peek()){
                    if(maxQueue.contains(b)){
                        maxQueue.remove(b);
                    }
                    else{
                        System.out.println("Wrong!");
                        continue;
                    }
                }
                else{
                    if(minQueue.contains(b)){
                        minQueue.remove(b);
                    }
                    else{
                        System.out.println("Wrong!");
                        continue;
                    }
                }
            }
            else{
                if(maxQueue.isEmpty() || b<=maxQueue.peek()){
                    maxQueue.add(b);
                }
                else{
                    minQueue.add(b);
                }
            }
            balance(maxQueue,minQueue);
            System.out.println(getMedian(maxQueue,minQueue));
        }
    }
    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        String a[]=new String[n];
        int[] x=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.next();
            x[i]=sc.nextInt();
        }
        //System.out.println("Solution");
        findMedian(a,x);
        sc.close();
    }
}