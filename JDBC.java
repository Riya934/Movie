import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
public class JDBC {
  public static void main(String args[])
  {
	  try { 
          
		  Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
			 
		System.out.println("Driver is loaded"+c1);
		System.out.println("NAME"+c1.getName());
		System.out.println("Canonical Name"+c1.getCanonicalName());
		System.out.println("modifier"+c1.getModifiers());
		System.out.println("Type Name"+c1.getTypeName());
		final String JdbcDriver="com.mysql.cj.jdbc.Driver";
		final String user="root";
		final String pass="";
		final String db_url="jdbc:mysql://127.0.0.1:3306/movie";
		Connection conn=(Connection) DriverManager.getConnection(db_url,user,pass);
		Statement st = conn.createStatement(); 
		Scanner sc=new Scanner(System.in);
          st.executeUpdate("INSERT INTO Movies " + 
              "VALUES ('Bell Bottom' , 'Akshay Kumar', 'Vaani Kapoor', 'Ranjit Tiwari', 2021)"); 
          st.executeUpdate("INSERT INTO Movies " + 
              "VALUES ('RRR', 'Ram Charan', 'Alia Bhatt', 'Rajamouli', 2022)"); 
          ResultSet rs=st.executeQuery("Select * from Movies");
 		 System.out.println("The records from table");
 		 while(rs.next())
 		 {
 			 System.out.println("Movie name:" + rs.getString(1) + "Lead Actor:" + rs.getString(2) + "Lead Actress:" + rs.getString(3) + "Director:" + rs.getString(4) + "Year of Release:" + rs.getInt(5));
 		 }
 		ResultSet rs1=st.executeQuery("select * from movies");
		System.out.println("Enter actor name to find his movies");
		String y=sc.next();
		while(rs1.next())
		{
			if((rs1.getString(2).equals(y))==true)
			System.out.println("Movie name : "+rs.getString(1));
		}
          conn.close(); 
      } catch (Exception e) { 
          System.err.println("Got an exception! "); 
          System.err.println(e.getMessage()); 
      } 
	 
  }
}
