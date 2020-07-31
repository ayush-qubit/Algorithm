import java.util.Scanner;

public class ArraySimpleQueries{
    public static String Solution(String str,int i,int j,int code){
        int n=str.length();
        if(code==1){
            String temp=str.substring(i-1,j);
            str=str.substring(0,i-1)+str.substring(j,n);
            str=temp+str;
        }
        else{
            String temp=str.substring(i-1,j);
            str=str.substring(0,i-1)+str.substring(j,n);
            str=str+temp;
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String str="";
        for(int i=0;i<n;i++){
            String s=sc.next();
            str+=s;
        }
        for(int i=0;i<m;i++){
            int code=sc.nextInt();
            int start=sc.nextInt();
            int end=sc.nextInt();
            str=Solution(str,start,end,code);
        }
        char ch1=str.charAt(0);
        char ch2=str.charAt(n-1);
        int a=Integer.parseInt(Character.toString(ch1));
        int b=Integer.parseInt(Character.toString(ch2));
        System.out.println(Math.abs(a-b));
        for(int i=0;i<n;i++){
            System.out.print(str.charAt(i)+" ");
        }
        sc.close();
    }
}