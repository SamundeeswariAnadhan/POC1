package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class department {
    static final String DB_URL = "jdbc:mysql://localhost:3306/chami";
    static final String USER ="chami";
    static final String PASS ="1234";

    public static void main(String[] args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String drops = "DROP TABLE IF EXISTS department";
            stmt.executeUpdate(drops);


            String sql = "CREATE TABLE IF NOT EXISTS DEPARTMENT " +
                    "(DepID smallint , " +
                    " Department VARCHAR(30), " +
                    " PRIMARY KEY ( DepID ))";

            stmt.executeUpdate(sql);
            System.out.println("table created for department table");


            System.out.println("Inserting records into the table...");
            sql = "INSERT INTO Department VALUES (111, 'CSE')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Department VALUES (112, 'EEE')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Department VALUES (113, 'IT')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Department VALUES(114, 'ECE')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Department VALUES(115, 'Arch')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Department VALUES(116, 'MECH')";
            stmt.executeUpdate(sql);

            System.out.println("data inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}








	/*public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
//            Creating Table
        /* String sql = "CREATE TABLE DEPARTMENT" +
                    "(DEPTID smallint not NULL, " +

                    " Deptname  VARCHAR(255), " +
                    " PRIMARY KEY ( DEPTID ))";
            stmt.executeUpdate(sql);
            System.out.println("DEPARTMENT TABLE CREATED.....");


            System.out.println("Inserting department records into the table...");
             sql = "INSERT INTO DEPARTMENT VALUES (1, 'CS')";
            stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (2, 'EEE')";
             stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (3, 'IT')";
             stmt.executeUpdate(sql);
             sql = "INSERT INTO DEPARTMENT VALUES (4, 'ECE')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO DEPARTMENT VALUES (5, 'Arch')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO DEPARTMENT VALUES (6, 'Mech')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted department records ...");



        	Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("SELECT *FROM " + "students" + " NATURAL JOIN " + "department");
            System.out.println("stuID" + " FirstName " + "LastName" + "DeptID" + "Deptname");
            while (res.next()) {
                String stuID = res.getString("stuID");
                String FirstName = res.getString("FirstName");
                String LastName = res.getString("LastName");

                String DeptID = res.getString("DeptID");
                String Deptname = res.getString("Deptname");
                // Beautification of output
                System.out.format(
                        "%10s%10s%10s%10s%20s\n", stuID, FirstName, LastName,DeptID,Deptname);
            }
	} catch (SQLException e) {
        e.printStackTrace();
    }
}
}*/




