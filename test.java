import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        String[] str=new String[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<4;i++){
            str[i]=sc.next();
        }
        for(int i=0;i<4;i++){
            System.out.println(str[i]);
        }
        sc.close();
    }
}