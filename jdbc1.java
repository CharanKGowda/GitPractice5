package jdbcex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
//Just typing something to modify
public class jdbc1 {
//using for conflict
	//modifying again
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306"; 
		Scanner sc =new Scanner(System.in);
		System.out.println("Press\n 1 to Insert into the table \n 2 to Update the table \n 3 to delete data in the table \n 4 to Display the data in the table\n 5 To Exit ");
		int n=sc.nextInt();
		if(n==1) {
		System.out.println("Enter the data to be inserted");
		System.out.println("First name");
		System.out.prinln();
		String Fin=sc.next();
		System.out.println("Last name");
		String Ln=sc.next();
		System.out.println("Middle name");
		String Mn=sc.next();
		System.out.println("Customer city");
		String c_c=sc.next();
		System.out.println("Customer_number");
		System.out.println();
		String cn=sc.next();
		try {
			
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/db2","root","root");
		Statement s=con.createStatement();
		String q1="insert into customer values('"+Fin+"','"+Ln+"','"+Mn+"','"+c_c+"','"+cn+"')";
		int x = s.executeUpdate(q1);
                if (x > 0)           
                    System.out.println("Successfully Inserted");           
                else           
                    System.out.println("Insert Failed");
               
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
		}
		if(n==2) {
			System.out.println("Enter the data to be updated");
			System.out.println("Field to be updated");
			String fu=sc.next();
			System.out.println("Data to be updated");
			String du=sc.next();
			System.out.println("Condition Field to be updated");
			String cu=sc.next();
			System.out.println("Condition Data to be updated");
			String cdu=sc.next();
			try {
			Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/db2","root","root");
			Statement s=con.createStatement();
			String q1="update customer set "+fu+" = '" + du +"' where "+cu+" = '" +cdu+ "'";
			int x = s.executeUpdate(q1);
            
            if (x > 0)           
                System.out.println("Successfully Updated");           
            else           
                System.out.println("ERROR OCCURED ");
             
            
		}
			catch(Exception e)
	        {
	            System.out.println(e);
	        }
	}
		if(n==3) {
			System.out.println("Condition Field for deleteion");
			String cd=sc.next();
			System.out.println("Condition Data for deletion");
			String cdd=sc.next();
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/db2","root","root");
				Statement s=con.createStatement();
				String q1="DELETE from customer WHERE "+cd+" = '" + cdd +"'";
				int x = s.executeUpdate(q1);
	            
	            if (x > 0)           
	                System.out.println("Successfully Deleted");           
	            else           
	                System.out.println("ERROR OCCURED ");
	             
	            
			}
				catch(Exception e)
		        {
		            System.out.println(e);
		        }
		}
		if(n==4) {
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/db2","root","root");
				Statement s=con.createStatement();
				String q1="select * from customer";
				ResultSet rs = s.executeQuery(q1);
				while(rs.next()) {
					System.out.println("Firstname\t"+rs.getString("Firstname"));
					System.out.println("Lastname\t"+rs.getString("Lastname"));
					System.out.println("Middlename\t"+rs.getString("Middlename"));
					System.out.println("Customer_city\t"+rs.getString("customer_city"));
					
				}
		}
			catch(Exception e)
	        {
	            System.out.println(e);
	        }
		}
		if(n==5) {
			Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/db2","root","root");
			Statement s=con.createStatement();
			con.close();
		}
	}
}


