package jdbcnew;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class deleterow {
	static final String DB_URL = "jdbc:mysql://localhost:3306/poc";
	static final String USER ="root";
	static final String PASS ="1234";
	
	public static void main(String[] args) 
	{
      
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        		
        			
        ) {
        	System.out.println("\nConnection successful!\n");
        	PreparedStatement stmt1 = null;	
        	stmt1 = conn.prepareStatement("delete from Student where StudID = ?");
        		
      

            FileInputStream fstream = new FileInputStream("C:\\Users\\s.anandhan\\Desktop\\poc\\deletestudent.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int count = in.available();
            String s;
            ArrayList list = new ArrayList();
            while ((s = br.readLine()) != null)
            {
                list.add(s);
                System.out.println(s);
                stmt1.executeUpdate("delete from student where studID="+s);
            
            }
        }	
            catch (SQLException | FileNotFoundException throwables)
        {
            throwables.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
         		}
}