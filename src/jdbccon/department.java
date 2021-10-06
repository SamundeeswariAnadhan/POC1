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
		    ResultSet res = st.executeQuery("select studID, FirstName, LastName,joiningDate,DOB,MobileNo,EmailID, Department\n" +
		            "from student \n" +
		            "join Department \n" +
		            "On student.DepID = Department.DepID");
		    System.out.println("stuID" + " FirstName " + "LastName"+ "joiningDate"+ "DOB"+"MobileNo"+"EmailID"+ "DepID" + "Department");
		    while (res.next()) {
		        String stuID = res.getString("studID");
		        String FirstName = res.getString("FirstName");
		        String LastName = res.getString("LastName");
		        String joiningDate = res.getString("joiningDate");
		        String DOB = res.getString("DOB");
		        String MobileNo = res.getString("MobileNo");
		        String EmailID = res.getString("EmailID");
		        
		        //String DepID = res.getString("DepID");
		        String Department = res.getString("Department");
		     
		        System.out.format(
		                "%10s%10s%10s%10s%10s%20s%20s%20s\n",stuID, FirstName, LastName, joiningDate, DOB,MobileNo,EmailID ,Department);
		    
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
	








	



