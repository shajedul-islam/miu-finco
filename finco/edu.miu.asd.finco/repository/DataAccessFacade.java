package repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import domain.impl.Account;
import domain.impl.Customer;
import repository.impl.DataAccess;

public class DataAccessFacade implements DataAccess{
	
	enum StorageType {
		Accounts, CCAcounts, Customer, Entries;
	}

	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\datastorage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	@Override
	public void SaveAccount(Account account) {
		HashMap<String, Account> accounts = readAccountMap();
		String accnumber = account.getAccNumber();
		accounts.put(accnumber, account);
		saveToStorage(StorageType.Accounts, accounts);	
	}

	@Override
	public void SaveCustomer(Customer customer) {
		HashMap<String, Customer> customers = readCustomerMap();
		String name = customer.getName();
		customers.put(name, customer);
		saveToStorage(StorageType.Customer, customers);	
	}
	
	public HashMap<String, Account> readAccountMap() {
		//Returns a Map with name/value pairs being
		// accountNumber -> Customer
		
		HashMap<String, Account> accounts = (HashMap<String, Account>) readFromStorage(StorageType.Accounts);
		if(accounts == null)
		{
			accounts = new HashMap<String, Account>();
		}
		return accounts;
	}
	
	public HashMap<String, Customer> readCustomerMap() {
		//Returns a Map with name/value pairs being
		//   memberId -> LibraryMember
		return (HashMap<String, Customer>) readFromStorage(
				StorageType.Customer);
	}
	
	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			InputStream dd =  Files.newInputStream(path);
			in = new ObjectInputStream(dd);
			retVal = in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return retVal;
	}
	
	final static class Pair<S,T> implements Serializable{
		
		S first;
		T second;
		Pair(S s, T t) {
			first = s;
			second = t;
		}
		@Override 
		public boolean equals(Object ob) {
			if(ob == null) return false;
			if(this == ob) return true;
			if(ob.getClass() != getClass()) return false;
			@SuppressWarnings("unchecked")
			Pair<S,T> p = (Pair<S,T>)ob;
			return p.first.equals(first) && p.second.equals(second);
		}
		
		@Override 
		public int hashCode() {
			return first.hashCode() + 5 * second.hashCode();
		}
		@Override
		public String toString() {
			return "(" + first.toString() + ", " + second.toString() + ")";
		}
		private static final long serialVersionUID = 5399827794066637059L;
	}


}
