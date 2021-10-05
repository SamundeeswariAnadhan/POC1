
package jdbccon;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;


import java.sql.*;

class STUDENT {
    static final String DB_URL = "jdbc:mysql://localhost:3306/chami";
    static final String USER ="chami";
    static final String PASS ="1234";


    public static void main(String[] args) {


        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();

        ) {

            String drop = "DROP TABLE IF EXISTS student";
            stmt.executeUpdate(drop);

            String sql = "CREATE TABLE IF NOT EXISTS Student "
                    + "(StudID int, " + " FirstName VARCHAR(30), "
                    + " LastName VARCHAR(30), " + " DepID int, " + " JoiningDate date, " + " DOB date, "
                    + " MobileNo bigint," + " EmailID NVARCHAR(50),"
                    + " PRIMARY KEY ( StudID ))";
            stmt.executeUpdate(sql);
            System.out.println("Table created");



//	            Inserting values

            sql = "INSERT INTO Student VALUES(01, 'Samundeeswari', 'Anandhan', 111 , '2021-01-20' , '1997-10-02' , 9867565654 , 'samu@gmail.com')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Student VALUES (02, 'selciya', 'nayagam', 112 , '2021-02-20' , '1998-10-20' , 9766765645 , 'selci@gmail.com')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Student VALUES (06, 'keerthana', 'deivasigamani', 113 , '2021-04-20' , '1996-11-13' , 9878756534 , 'keerthana@gmail.com')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Student VALUES (07, 'rajkumar', 'mariyapan', 114 , '2021-03-10' , '1997-10-25' , 9767576565 , 'raj@gmail.com')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Student VALUES(08, 'Santhi', 'vardhan', 115 , '2021-07-10' , '1997-10-18' , 8087565455 , 'santhi@gmail.com')";
            stmt.executeUpdate(sql);

            System.out.println("values inserted.....");

//	           file insert
            Statement st = conn.createStatement();
            FileInputStream f = new FileInputStream("C:\\Users\\s.anandhan\\Desktop\\POC-DBData\\input.txt");
            DataInputStream in = new DataInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList list = new ArrayList();
            while ((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext(); ) {
                String str = itr.next().toString();
                String[] sp = str.split("\t");
                String sid = "", fname = "", lname = "", deptID = "", joinDate = "", dob = "", phNo = "", email = "";
                for (int i = 0; i <= 8; i++) {
                    sid = sp[0];
                    fname = sp[1];
                    lname = sp[2];
                    deptID = sp[3];
                    joinDate = sp[4];
                    dob = sp[5];
                    phNo = sp[6];
                    email = sp[7];
                }
                ResultSet rsSet = null;
                Statement Stmnt1 = conn.createStatement();
                rsSet = Stmnt1.executeQuery("select * from department");
                while(rsSet.next()){
                    if(deptID.equals(rsSet.getString("Department"))){
                        deptID=new String(rsSet.getString("DepID"));
                    }}int k = Stmnt1.executeUpdate("insert into student(StudID, FirstName, LastName, DepID, JoiningDate, DOB, MobileNo, EmailID) values('" + sid + "','" + fname + "','" + lname + "','" + deptID + "','" + joinDate + "','"+dob +"','"+phNo+"','"+email+"')");
                System.out.println("inserted "+fname+"into db");


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}






