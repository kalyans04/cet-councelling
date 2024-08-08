import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class counsellor {
    static void request(int a){
        if(a==101){
            selects(1,25000);
        }
        else if(a==102){
            selects(25000,50000);
        }
        else if(a==103){
            selects(50000,75000);
        }
        else if(a==103){
            selects(75000,100000);
        }
        else{
            System.out.println("Wrong id");
        }
    }
    static void selects(int x,int y) {
        try {
            Connection con=DatabaseConnector.getConnection();
            Statement stmt = con.createStatement();
            String sql="select * from students where id between "+x+" and "+y;
            ResultSet r = stmt.executeQuery(sql);
            Systefm.out.println("The Requests are:");
           int temp=0;
            while (r.next()) {
                temp=1;
                System.out.print("first name :" + r.getString("first"));
                System.out.print("  last name:" + r.getString("last"));
                System.out.print("  district:" + r.getString("district"));
                System.out.print("  rank:" + r.getInt("ranking"));
                System.out.print("  phone number:" + r.getLong("phone"));
                System.out.println("  id:" + r.getInt("id"));

            }
            if(temp==0){
                System.out.println("No new Requests");
            }
            else {
                System.out.println("Enter the student id you want to evaluate:");
                Scanner sc=new Scanner(System.in);
                int n= sc.nextInt();
                result.approv(n);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
