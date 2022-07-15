package project.bank.edu.miu.asd.bank.repository.impl;

import domain.impl.*;
import project.bank.edu.miu.asd.bank.Bank;
import project.bank.edu.miu.asd.bank.domain.BankAccount;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.domain.impl.Checkings;
import project.bank.edu.miu.asd.bank.domain.impl.Person;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessFacadeBank implements BankDataAccess {

	private Connection connectNew() 
	{  
        // SQLite connection string  
        String url = "jdbc:sqlite:bank.db";
        //String url = "jdbc:sqlite:bank.db";
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
	public int SaveAccount(BankAccount account) {
		String sql = "INSERT INTO Account(CustomerId,AccountNumber, AccountType,CompanyPerson) VALUES(?,?,?,?)";
        int accountId = 0;
        try{  
            Connection conn = this.connectNew(); 
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            pstmt.setInt(1, account.getCustomerId());  
            pstmt.setString(2, account.getAccNumber());
            pstmt.setString(3, account.getAccount_type());
            pstmt.setString(4, account.getCompany_or_person());
            pstmt.executeUpdate();  
            
            accountId = getLastRowId(conn);
            
            account.setId(accountId);
          
            conn.close();
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return accountId;
		
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
	public void SaveCustomer(BankCustomer customer) {
		
		String sql = "INSERT INTO Customer(Name,Street,City,State,Zip,Email,BirthDate,NoOfEmployee) VALUES(?,?,?,?,?,?,?,?)";
		   
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
            pstmt.setDouble(8, customer.getNo_of_employees());
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
            pstmt.setString(2, entry.getDate());
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
	public BankAccount getAccountByAccountNumber(String accNumber) {
		String sql = "SELECT * FROM Account where AccountNumber = '"+accNumber+"' limit 1";
		int id = 0;
		String accountNo = "";
		int customerId = 0;
        double balance = 0;
        String accountType = "";
        String companyPerson = "";
		BankAccount account = new Checkings(accountNo);
        try {  
        	Connection conn = this.connectNew(); 
        	java.sql.Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {
            	id = rs.getInt("Id");
            	customerId = rs.getInt("CustomerId");
            	accountNo = rs.getString("AccountNumber");
                balance = rs.getDouble("Balance");
            }
            rs.close();
            conn.close();

            account = new Checkings(accountNo);
            account.setCustomerId(customerId);
            account.setId(id);
            account.setCompany_or_person(companyPerson);
            account.setAccount_type(accountType);
            account.setBalance(balance);
            
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        return account;
	}

    @Override
    public List<BankCustomer> getallCustomer() {
        String sql = "SELECT * FROM Customer";

        int id = 0;
        String name = "";
        String street = "";
        String city = "";
        String state = "";
        String zip = "";
        String email = "";

        List<BankCustomer> customers = new ArrayList<BankCustomer>();

        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                id = rs.getInt("Id");
                name = rs.getString("Name");
                street = rs.getString("Street");
                city = rs.getString("City");
                state = rs.getString("State");
                zip = rs.getString("Zip");
                email = rs.getString("Email");
                Person c = new Person(name, street, city, state, zip, email, null);
                c.setId(id);
                customers.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (BankCustomer cus : customers) {
            List<BankAccount> accounts = getAccountByCustomerId(cus.getId());
            for (BankAccount ac : accounts) {
                cus.addBankAccount(ac);
            }
        }
        return customers;
    }

    @Override
    public List<BankAccount> getAccountByCustomerId(int custId) {
        String sql = "SELECT * FROM Account where CustomerId = " + custId;
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        String accountType = "";
        String companyPerson = "";
        List<BankAccount> accounts = new ArrayList<BankAccount>();

        BankAccount account = new Checkings(accountNo);
        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                id = rs.getInt("Id");
                customerId = rs.getInt("CustomerId");
                accountNo = rs.getString("AccountNumber");
                accountType = rs.getString("AccountType");
                companyPerson = rs.getString("CompanyPerson");
                balance = rs.getDouble("Balance");
                account = new Checkings(accountNo);
                account.setCustomerId(customerId);
                account.setBalance(balance);
                account.setCompany_or_person(companyPerson);
                account.setAccount_type(accountType);
                account.setId(id);
                accounts.add(account);
            }
            rs.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return accounts;
    }

    @Override
    public List<BankAccount> getallAccounts() {
        String sql = "SELECT * FROM Account";
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        String accountType = "";
        String companyPerson = "";
        List<BankAccount> accounts = new ArrayList<BankAccount>();

        BankAccount account = new Checkings(accountNo);
        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                id = rs.getInt("Id");
                customerId = rs.getInt("CustomerId");
                accountNo = rs.getString("AccountNumber");
                balance = rs.getDouble("Balance");
                accountType = rs.getString("AccountType");
                companyPerson = rs.getString("CompanyPerson");
                account = new Checkings(accountNo);
                account.setCustomerId(customerId);
                account.setCompany_or_person(companyPerson);
                account.setAccount_type(accountType);
                account.setBalance(balance);
                account.setId(id);
                accounts.add(account);
            }
            rs.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return accounts;
    }

    @Override
    public BankCustomer getCustomerById(int custId) {

        String sql = "SELECT * FROM Customer where Id = " + custId;
        int id = 0;

        BankCustomer customer = null;

        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            // loop through the result set
            while (rs.next()) {
                //customer.setId(rs.getInt("Id"));
                //customer.setName(rs.getString("Name"));
                //customer.setStreet(rs.getString("Street"));
                //customer.setCity(rs.getString("City"));
                //customer.setState(rs.getString("State"));
                //customer.setZip(rs.getString("Zip"));
                //customer.setEmail(rs.getString("Email"));

                String name = rs.getString("Name");
                String street = rs.getString("Street");
                String city = rs.getString("City");
                String state = rs.getString("State");
                String zip = rs.getString("Zip");
                String email = rs.getString("Email");


                customer = new Person(name, street, city, state, zip, email, null);
            }
            rs.close();
            conn.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customer;
    }

    @Override
    public void updateAccount(BankAccount account) {
        String sql = "Update Account SET Balance = ? , AccountNumber = ? , CustomerId = ? Where Id = ?";

        try {
            Connection conn = this.connectNew();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, account.getBalance());
            pstmt.setString(2, account.getAccNumber());
            pstmt.setDouble(3, account.getCustomerId());
            pstmt.setDouble(4, account.getId());
            pstmt.executeUpdate();

            int accountId = getLastRowId(conn);

            account.setId(accountId);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
