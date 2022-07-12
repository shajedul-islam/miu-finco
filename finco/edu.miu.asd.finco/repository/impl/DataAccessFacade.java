package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.impl.Account;
import domain.impl.ConcreteAccount;
import domain.impl.Customer;
import domain.impl.Entry;
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
	
	private int getLastRowId(Connection conn) 
	{
		String sql  = "select last_insert_rowid() as Last";
		int maxId = 0;
		try
		{
	        PreparedStatement pstmt1 = conn.prepareStatement(sql); 
	        
	        ResultSet rs1 = pstmt1.executeQuery();
	        maxId=  rs1.getInt("Last");
	        rs1.close();
	        return maxId;
		}
		catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
		return maxId;
	}
	
	@Override
	public void SaveAccount(Account account) {
		String sql = "INSERT INTO Account(CustomerId,AccountNumber) VALUES(?,?)";  
		   
        try{  
            Connection conn = this.connectNew(); 
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, account.getCustomerId());  
            pstmt.setString(2, account.getAccNumber());  
            pstmt.executeUpdate();  
            
            int accountId = getLastRowId(conn);
            
            account.setId(accountId);
          
            conn.close();
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
		
		String sql = "INSERT INTO Customer(Name,Street,City,State,Zip,Email,BirthDate) VALUES(?,?,?,?,?,?,?)";  
		   
        try{  
            Connection conn = this.connectNew(); 
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setString(1, customer.getName());  
            pstmt.setString(2, customer.getStreet()); 
            pstmt.setString(3, customer.getCity()); 
            pstmt.setString(4, customer.getState()); 
            pstmt.setString(5, customer.getZip()); 
            pstmt.setString(6, customer.getEmail()); 
            pstmt.setString(7, "2022/02/02");
            pstmt.executeUpdate();  
            
            int customerId = getLastRowId(conn);
            customer.setId(customerId);
       
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
	}

	@Override
	public void saveEntry(Entry entry) {
		String sql = "INSERT INTO Entry(AccountId,Date,Amount,TrasactionType) VALUES(?,?,?,?)";  
		   
        try{  
            Connection conn = this.connectNew(); 
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, entry.getAccountId());  
            pstmt.setDate(2, entry.getDate()); 
            pstmt.setDouble(3, entry.getAmount()); 
            pstmt.setString(4, entry.getTransactionType().toString()); 
            pstmt.executeUpdate();  
            
            int entryId = getLastRowId(conn);
            entry.setId(entryId);
       
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
		
	}

	@Override
	public Account getAccountByAccountNumber(String accNumber) {
		String sql = "SELECT * FROM Account where AccountNumber = '"+accNumber+"' limit 1";
		//String sql = "SELECT * FROM Account";
		int id = 0;
		String accountNo = "";
		int customerId = 0;
		Account account = new ConcreteAccount(accountNo);
        try {  
        	Connection conn = this.connectNew(); 
        	java.sql.Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
            	id = rs.getInt("Id");
            	customerId = rs.getInt("CustomerId");
            	accountNo = rs.getString("AccountNumber");
            }
            rs.close();
            conn.close();

            account = new ConcreteAccount(accountNo);
            account.setCustomerId(customerId);
            account.setId(id);
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return account;
	} 
}
