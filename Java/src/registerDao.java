import java.sql.*;
import java.time.LocalDate;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;


public class registerDao {
	public static void main(String[] args) throws Exception,ClassNotFoundException{
//		System.out.println(check("Abhishek","CmyM@2020"));		
	}
	
	public String uid(String uname, String email, String password) throws ClassNotFoundException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JAR File exists");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncp", "root", "akash2000");
			Statement stmt = con.createStatement();
			String sql = "select * from Users where username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,email);
			st.setString(3,password);
			System.out.println(st.toString());
			//q1
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString("userid"));
				return rs.getString("userid");
			}
		}
		catch (SQLException ex) {
			System.out.println(ex);
		}
		return "";
	}
	
	public int check(String uname, String emailid, String password) throws ClassNotFoundException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JAR File exists");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ncp", "root", "akash2000");
			Statement stmt = con.createStatement();
			String sql = "select * from Users where username=? and password=?"; // matching part username and password -> email;  
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,password);
			System.out.println(st.toString());
			//q1
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString("role"));	
//				if(rs.getString("role").equals("Admin"))
//					return 2;
//
//				return 1;
				
				
//				User  already exists try login;
				return 0;
			}
			else 
			{
				LocalDate myObj = LocalDate.now();
				String membersince = myObj.toString();
				String role = "Samaritan";
				String status = "Active";
				String sql2 = "insert into users(userid,username,password,emailid,membersince,role,status) values (default,?,?,?,?,?,?)";
				PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
	
				st2.setString(1,uname);
				st2.setString(2,password);
				st2.setString(3, emailid);
				st2.setString(4, membersince);
				st2.setString(5, role);
				st2.setString(6, status);
				System.out.println(st.toString());
				//q1
				int rs2 = st2.executeUpdate();
				ResultSet rsx = st2.getGeneratedKeys();
				
				if(rs2>0)
				return 1;
			}
		}
		catch (SQLException ex) {
			System.out.println(ex);
		}
		return 0;
	}
}
