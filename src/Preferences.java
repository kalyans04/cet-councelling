import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Preferences {
    public static void prefers(int id) {
        try{
            Connection con=DatabaseConnector.getConnection();
            Scanner scanner = new Scanner(System.in);
            preferens.districts();
            System.out.print("Enter district 1: ");
            String d1 = scanner.next();
            System.out.print("Enter district 2: ");
            String d2 = scanner.next();
            System.out.print("Enter district 3: ");
            String d3 = scanner.next();
            preferens.branches();
            System.out.print("Enter Branch 1: ");
            String b1 = scanner.next();
            System.out.print("Enter Branch 2: ");
            String b2 = scanner.next();
            System.out.print("Enter Branch 3: ");
            String b3 = scanner.next();
            addprefers(con,id,d1,d2,d3,b1,b2,b3);

            System.out.println("your preferences are\n:"+d1+"\n"+d2+"\n"+d3+"\n"+b1+" "+b2+" "+b3);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addprefers(Connection con,int id,String d1,String d2,String d3,String b1,String b2,String b3) throws SQLException {
        String sql = "INSERT INTO preferences VALUES (?,?, ?, ?,?,?,?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2,b1);
            statement.setString(3, b2);
            statement.setString(4, b3);
            statement.setString(5, d1);
            statement.setString(6,d2);
            statement.setString(7, d3);
            statement.executeUpdate();
            System.out.println("Data inserted successfully!");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
