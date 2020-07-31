import java.util.Scanner;

public class ModularExponentiation{
    public static int power(int x,int y,int p) {
        if(x==0){
            return 0;
        }else{
            int res=1;
            x=x%p;
            while(y>0){
                if(y%2==1){
                    res*=x;
                    res=res%p;
                }
                y=y/2;
                x=(x*x)%p;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        int x,y,p;
        Scanner sc=new Scanner(System.in);
        x=sc.nextInt();
        y=sc.nextInt();
        p=sc.nextInt();
        System.out.println("Power is: "+power(x, y, p));
        sc.close();
    }
}