import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.io.*;
public class student{
    private String firstname;
    private String lastname;
    private String district;
    private long phno;
    private int rank;
    public student(String fn,String ln,int r,String d,long pn){
        this.firstname=fn;
        this.lastname=ln;
        this.rank=r;
        this.phno=pn;
        this.district=d;
    }
    public int getRank(){
        return this.rank;
    }

    public static void newstud() {
        try{            Connection con=DatabaseConnector.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your Details:");
            System.out.print("Enter first name: ");
            String name = scanner.next();
            System.out.print("Enter last name: ");
            String name2 = scanner.next();
            System.out.print("Enter rank: ");
            int rank= scanner.nextInt();
            if(rank > 100000){
                System.out.println("We cannot allot you seat");
                System.exit(-1);
            }
            System.out.print("Enter your district: ");
            String dis = scanner.next();
            System.out.print("Enter your phonenumber: ");
            long num = scanner.nextLong();
            int id=rank;
            addstudent(con,id,name,name2,rank,dis,num);
            System.out.println("your id is:"+id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addstudent(Connection con, int id,String f,String l, int r, String d,long n) throws SQLException {
        String sql = "INSERT INTO students  VALUES (?, ?, ?,?,?,?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, f);
            statement.setString(2,l);
            statement.setString(3, d);
            statement.setInt(4, r);
            statement.setLong(5, n);
            statement.setInt(6,id);


            statement.executeUpdate();
            System.out.println("Data inserted successfully!");
        }
        catch (Exception e) {
        }
    }
}










