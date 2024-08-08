
import java.util.*;
public class login {
    public static int login(){
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("---------Student Counselling portal----------");
        System.out.println("1)Student\n2)Counsellor");
        System.out.println("Enter choice:");
        n = sc.nextInt();
        return n;
    }
}
