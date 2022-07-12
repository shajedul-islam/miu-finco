package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.impl.Account;
import domain.impl.Customer;
import repository.DataAccess;

public class DataAccessFacade implements DataAccess{

	private Connection connectNew() 
	{  
        // SQLite connection string  
        String url = "jdbc:sqlite:E:/MIU/sql/simple.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
	}  
	
	@Override
	public void SaveAccount(Account account) {
		String sql = "INSERT INTO Account(AccountNumber) VALUES(?)";  
		   
        try{  
            Connection conn = this.connectNew(); 
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, account.getAccNumber());  
            pstmt.executeUpdate();  
            //conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
		
	}
	
	 public void selectAll(){  
	        String sql = "SELECT * FROM Account";  
	          
	        try {  
	            Connection conn = this.connectNew();  
	            java.sql.Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	                System.out.println(rs.getInt("Id") +  "\t" +   
	                                   rs.getString("Name"));  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	    }  
	   

	@Override
	public void SaveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	} 
}
