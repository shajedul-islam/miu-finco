package project.ccard.repository;

import domain.impl.*;
import project.ccard.domain.Gold;
import project.ccard.domain.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CCDataAccessFacade implements ICCDataAccess
{
    private Connection connectNew() {
        // SQLite connection string
        //String url = "jdbc:sqlite:bank.db";
        String url = "jdbc:sqlite:C:/ASD/ccard.db";
        Connection conn = null;
        try {
            Path path = Paths.get("");
            String directoryName = path.toAbsolutePath().toString();
            System.out.println("Current Working Directory is = " +directoryName);
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
    public void saveCCAccount(CCAccount account) {
        String sql = "INSERT INTO CCAccount(CustomerId,CCNumber,ExpiryDate,CardType,Balance) VALUES(?,?,?,?,?)";

        try {
            Connection conn = this.connectNew();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account.getCustomerId());
            pstmt.setString(2, account.getAccnr());
            pstmt.setString(3, account.getexpExpiryDate());
            pstmt.setString(4, account.getCardType());
            pstmt.setDouble(5, account.getBalance());
            pstmt.executeUpdate();

            int ccAccountId = getLastRowId(conn);

            account.setId(ccAccountId);

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCCAccount(CCAccount account) {
        String sql = "Update CCAccount SET Balance = ? , AccountNumber = ? , CustomerId = ? Where Id = ?";

        try {
            Connection conn = this.connectNew();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, account.getBalance());
            pstmt.setString(2, account.getAccnr());
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
    public void saveCustomer(Customer customer) {
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
    public CCAccount getCCAccountByAccountNumber(String ccAccNumber) {
        String sql = "SELECT * FROM CCAccount where CCNumber = '" + ccAccNumber + "' limit 1";
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        String expiryDate = "";
        String CardType = "";
        CCAccount account = new Gold(accountNo,null, null);
        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                id = rs.getInt("Id");
                customerId = rs.getInt("CustomerId");
                accountNo = rs.getString("CCNumber");
                balance = rs.getDouble("Balance");
                expiryDate = rs.getString("ExpiryDate");
                CardType = rs.getString("CardType");
            }
            rs.close();
            conn.close();

            account = new Gold(accountNo,expiryDate,CardType);
            account.setCustomerId(customerId);
            account.setBalance(balance);
            account.setCardType(CardType);
            account.setExp_date(expiryDate);
            account.setId(id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    @Override
    public List<CCAccount> getCCAccountByCustomerId(int custId) {
        String sql = "SELECT * FROM CCAccount where CustomerId = '" + custId + "'";
        int id = 0;
        String accountNo = "";
        int customerId = 0;
        double balance = 0;
        String expiryDate = "";
        String CardType = "";
        List<CCAccount> accounts = new ArrayList<CCAccount>();
        CCAccount account = new Gold(accountNo,null,null);
        try {
            Connection conn = this.connectNew();
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                id = rs.getInt("Id");
                customerId = rs.getInt("CustomerId");
                accountNo = rs.getString("CCNumber");
                balance = rs.getDouble("Balance");
                expiryDate = rs.getString("ExpiryDate");
                CardType = rs.getString("CardType");
            }
            rs.close();
            conn.close();

            account = new Gold(accountNo,expiryDate,CardType);
            account.setCustomerId(customerId);
            account.setBalance(balance);
            account.setCardType(CardType);
            account.setExp_date(expiryDate);
            account.setId(id);
            accounts.add(account);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    @Override
    public Customer getCustomerById(int custId) {
        String sql = "SELECT * FROM Customer where Id = " + custId;
        int id = 0;

        Customer customer = new Person("","","","","","") ;
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
            List<CCAccount> accounts = getCCAccountByCustomerId(cus.getId());
            for (CCAccount ac : accounts) {
                cus.AddAccount(ac);
            }
        }
        return customers;
    }

}
