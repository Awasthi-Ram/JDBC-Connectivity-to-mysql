
import java.sql.*;
public class dbcon {
    Connection con;
    dbcon(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionurl = "jdbc:mysql://localhost:3306/sampledb";
            String user = "root";
            String pass = "root";
            con = DriverManager.getConnection(connectionurl,user,pass);
            String viewquery = " select * from student; ";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(viewquery);

            while(rs.next())
            {
                System.out.print(" " + rs.getInt(1));
                System.out.print(" " + rs.getString(2));
                System.out.print(" " + rs.getInt(3));
                System.out.print(" " + rs.getString(4));
                System.out.print(" " + rs.getString(5));
                System.out.println(" " + rs.getInt(6));
            }

            System.out.println("connection Success ram");
        }
        catch (Exception e){
            System.out.println("connection failed ..." + e);

        }
    }

    public static void main(String[] args) {
        dbcon obj = new dbcon();
    }
}
