import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n=login.login();
        if(n == 1){
            System.out.println("Enter your id(if new user press 1):");
            int a=sc.nextInt();
            if(a!=1){
                System.out.println("the Result is:");
                result.approv(a);
            }
            else{
                student.newstud();
                System.out.println("Enter your id:");
                int x2 = sc.nextInt();
                System.out.println("Please enter preferences");
                System.out.println("Enter 3 Preferred districts and Branches/Courses");
                Preferences.prefers(x2);
                System.out.println("Thank you for Submitting your Request.");
                System.out.println("Result will be given shortly.");
            }

        }
        else if (n == 2){
            System.out.println("Enter id:");
            int id1=sc.nextInt();
            counsellor.request(id1);
        }
        else{
            System.out.println("Wrong Choice");
        }
    }
}
