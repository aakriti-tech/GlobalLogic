package com.gl.linking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyJdbc {
	public static void main(String[] args) {
		try{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/buddy";
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
//			String insertQuery="insert into Employee(id,FirstName,LastName,Salary,Dept) values(6,'Sejal','Yadav',41000,4)";
//			st.execute(insertQuery);
			String updateQuery="update Employee set salary=50001 where id=1";
			st.executeUpdate(updateQuery);
			String deleteQuery="delete from employee where id=5";
			st.executeUpdate(deleteQuery);
			String query="select *  from Employee";
			ResultSet rs=st.executeQuery(query);
			
			while(rs.next()){
				System.out.println("id: "+ rs.getInt("id")+ " FirstName: "+
			    rs.getString(2)+ " LastName: "+ rs.getString(3)+ " Salary: "+ rs.getInt(4)+
			    " Dept: "+ rs.getInt(5));
				
		}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}

}

