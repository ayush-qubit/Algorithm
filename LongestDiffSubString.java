import java.util.Arrays;
import java.util.Scanner;
public class LongestDiffSubString{
    public static int LongestLength(String str){
        int[] ch=new int[256];
        int n=str.length();
        char[] STR=str.toCharArray();
        int low=0,len=0;
        Arrays.fill(ch, -1);
        for(int high=0;high<n;high++){
            int pos=STR[high];
            low=Math.max(low,ch[pos]+1);
            len=Math.max(len, high-low+1);
            ch[pos]=high;
        }
        return len;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(LongestLength(str));
        sc.close();       
    }
}