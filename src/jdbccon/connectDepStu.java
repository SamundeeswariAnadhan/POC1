package jdbccon;

import java.sql.*;

public class connectDepStu
{

    static final String DB_URL = "jdbc:mysql://localhost:3306/chami";
    static final String USER ="chami";
    static final String PASS ="1234";

    public static void main(String[] args)
    {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select s.ID, s.FirstName, s.LastName, s.DeptID, d.Deptname\n" +
                    "from students s\n" +
                    "join Department d\n" +
                    "On s.DeptID = d.DeptID");
            System.out.println("ID" + " FirstName " + "LastName" + "Deptname" + "DeptID");
            while (res.next()) {
                String ID = res.getString("ID");
                String FirstName = res.getString("FirstName");
                String LastName = res.getString("LastName");
                String Deptname = res.getString("Deptname");
                String DeptID = res.getString("DeptID");
                // Beautification of output
                System.out.format(
                        "%10s%10s%10s%10s%20s\n", ID, FirstName, LastName, Deptname, DeptID);

            }

            // Step 7: Close the connection
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




