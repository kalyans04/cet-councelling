import java.sql.Connection;
import java.sql.SQLException;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class result {
    public static void approv(int id) {
        try {
            Connection con = DatabaseConnector.getConnection();
            String s1="select * from preferences where id="+id;
            Statement stmt = con.createStatement();
            ResultSet r = stmt.executeQuery(s1);
            String b1 = "", b2 = "", b3 = "", d1 = "", d2 = "", d3 = "";
            int rank = 0;
            ArrayList<String> branch = new ArrayList<String>();
            ArrayList<String> district = new ArrayList<String>();
            while (r.next()) {
                b1 = r.getString("branch1");
                b2 = r.getString("branch2");
                b3 = r.getString("branch3");
                d1 = r.getString("district1");
                d2 = r.getString("district2");
                d3 = r.getString("district3");
            }
            branch.add(b1);
            branch.add(b2);
            branch.add(b3);
            district.add(d1);
            district.add(d2);
            district.add(d3);
            String s2 = "select ranking from students where id=" + id;
            ResultSet r2 = stmt.executeQuery(s2);
            while (r2.next()) {
                rank = r2.getInt("ranking");
            }
            for (int i = 0; i < branch.size(); i++) {
                getinfo(branch.get(i), district.get(0), district.get(1), district.get(2), rank);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void getinfo(String b1, String d1, String d2, String d3, int rank) {
        try {
            Connection con = DatabaseConnector.getConnection();
            Statement stmt = con.createStatement();
            String s3 = "select * from colleges where " + rank + " between o_r and c_r and branch= '" + b1 + "' and region in('" + d1 + "','" + d2 + "','" + d3 + "')";
            ResultSet r3 = stmt.executeQuery(s3);
            System.out.println("Preferred colleges for " + b1 + " branch are:\n");
            if (r3.next() == false) {
                System.out.println("No college can be allotted in " + b1 + " branch");
            } else {
                while (r3.next()) {
                    System.out.println("College name :" + r3.getString("clgname") + " in the district " + d1);
                }
            }

            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
