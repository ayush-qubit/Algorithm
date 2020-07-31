import java.util.Comparator;
import java.util.PriorityQueue;
//import java.util.Scanner;

public class SlidingWindowsMedian {
    public static void balance(PriorityQueue<Integer> maxQueue,PriorityQueue<Integer> minQueue){
        if(minQueue.size()==maxQueue.size()+1){
            maxQueue.add(minQueue.poll());
        }
    }
    public static float getMedian(PriorityQueue<Integer> maxQueue,PriorityQueue<Integer> minQueue){
        float median;
        if(maxQueue.size()==minQueue.size()){
            float a=(float)maxQueue.peek();
            float b=(float)minQueue.peek();
            median=(a+b)/2;
        }
        else{
            float a=(float)maxQueue.peek();
            median=a;
        }
        return median;
    }
    public static void FindMedian(int[] arr,int n,int k){
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
        for(int i=0;i<k;i++){
            if(maxQueue.isEmpty()){
                maxQueue.add(arr[i]);
            }
            else if(minQueue.isEmpty()){
                minQueue.add(arr[i]);
            }
            else if(arr[i]<maxQueue.peek()){
                maxQueue.add(arr[i]);
            }
            else{
                minQueue.add(arr[i]);
            }
            balance(maxQueue,minQueue);
        }
        for(int i=1;i<n-k+1;i++){
            System.out.println(getMedian(maxQueue,minQueue));
            if(arr[i-1]<=maxQueue.peek()){
                maxQueue.remove(arr[i-1]);
            }
            else{
                minQueue.remove(arr[i-1]);
            }
            if(arr[i+k-1]<=maxQueue.peek()){
                maxQueue.add(arr[i+k-1]);
            }
            else{
                minQueue.add(arr[i+k-1]);
            }
            balance(maxQueue,minQueue);
        }
    }
    public static void main(String[] args) {
        int[] arr={-1,5,13,8,2,3,3,1};
        int n=arr.length;
        FindMedian(arr,n,3);
    }
}