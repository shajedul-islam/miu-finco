package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.impl.Account;
import domain.impl.ConcreteAccount;
import domain.impl.ConcretePerson;
import domain.impl.Customer;
import domain.impl.Entry;
import repository.DataAccess;

public class DataAccessFacade implements DataAccess {

    private Connection connectNew() {
        // SQLite connection string  
        String url = "jdbc:sqlite:C://ASD/finco.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    private int getLastRowId(Connection conn) {
        String sql = "select last_insert_rowid() as Last";
        int maxId = 0;
        try {
            PreparedStatement pstmt1 = conn.prepareStatement(sql);

            ResultSet rs1 = pstmt1.executeQuery();
            maxId = rs1.getInt("Last");
            rs1.close();
            return maxId;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return maxId;
    }

    @Override
    public void SaveAccount(Account account) {
        String sql = "INSERT INTO Account(CustomerId,AccountNumber,Balance) VALUES(?,?,?)";

        try {
            Connection conn = this.connectNew();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account.getCustomerId());
            pstmt.setString(2, account.getAccNumber());
            pstmt.setDouble(3, account.getBalance());
            pstmt.executeUpdate();

            int accountId = getLastRowId(conn);

            account.setId(accountId);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateAccount(Account account) {
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

    @Override
    public List<Customer> getallCustomer() {
        String sql = "SELECT * FROM Customer";

        int id = 0;
        String name = "";
        String street = "";
        String city = "";
        String state = "";
        String zip = "";
        String email = "";

        List<Customer> customers = new ArrayList<Customer>();

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
                Customer c = new ConcretePerson(name, street, city, state, zip, email);
                c.setId(id);
                customers.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Customer cus : customers) {
            List<Account> accounts = getAccountByCustomerId(cus.getId());
            for (Account ac : accounts) {
                cus.AddAccount(ac);
            }
        }
        return customers;
    }

    @Override
    public void SaveCustomer(Customer customer) {

        String sql = "INSERT INTO Customer(Name,Street,City,State,Zip,Email) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = this.connectNew();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getStreet());
            pstmt.setString(3, customer.getCity());
            pstmt.setString(4, customer.getState());
            pstmt.setString(5, customer.getZip());
            pstmt.setString(6, customer.getEmail());
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

        try {
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
    public Account getAccountByAccountNumber(String accNumber) {
        String sql = "SELECT * FROM Account where AccountNumber = '" + accNumber + "' limit 1";
        //String sql = "SELECT * FROM Account";
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        Account account = new ConcreteAccount(accountNo);
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
            }
            rs.close();
            conn.close();

            account = new ConcreteAccount(accountNo);
            account.setCustomerId(customerId);
            account.setBalance(balance);
            account.setId(id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    @Override
    public List<Account> getAccountByCustomerId(int custId) {
        String sql = "SELECT * FROM Account where CustomerId = " + custId;
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        List<Account> accounts = new ArrayList<Account>();

        Account account = new ConcreteAccount(accountNo);
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
                account = new ConcreteAccount(accountNo);
                account.setCustomerId(customerId);
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
    public Customer getCustomerById(int custId) {
        String sql = "SELECT * FROM Customer where Id = " + custId;
        int id = 0;

        Customer customer = new ConcretePerson();
        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                customer.setId(rs.getInt("Id"));
                customer.setName(rs.getString("Name"));
                customer.setStreet(rs.getString("Street"));
                customer.setCity(rs.getString("City"));
                customer.setState(rs.getString("State"));
                customer.setZip(rs.getString("Zip"));
                customer.setEmail(rs.getString("Email"));
            }
            rs.close();
            conn.close();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

}
