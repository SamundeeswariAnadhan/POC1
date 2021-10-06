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
                    "(DepID smallint not null , " +
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

	





	



