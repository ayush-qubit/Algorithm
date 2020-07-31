import java.util.Scanner;

public class NextGenCoder {
    public static int CountCharacter(String str1,String str2){
        int count=0;
        for(int i=0,j=0;i<str1.length() && j<str2.length();i++,j++){
            if(Character.toLowerCase(str1.charAt(i))==Character.toLowerCase(str2.charAt(j))){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str1,str2;
        Scanner sc=new Scanner(System.in);
        str1=sc.next();
        str2=sc.next();
        System.out.println(CountCharacter(str1, str2));
        sc.close();
    }
}