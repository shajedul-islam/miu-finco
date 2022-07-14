package project.bank.edu.miu.asd.bank.repository.impl;

import domain.impl.Customer;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;

import java.util.List;

public class BankCustomerRepository implements IBankCustomerRepository{

	public BankDataAccess dataaccess;

	public BankDataAccess getDataaccess() {
		return dataaccess;
	}

	public void setDataaccess(BankDataAccess dataaccess) {
		this.dataaccess = dataaccess;
	}
	public BankCustomerRepository()
	{

	}
	
	@Override
	public void save(BankCustomer customer) {
		
		dataaccess.SaveCustomer(customer);
	}

	@Override
	public List<BankCustomer> getallCustomer() {

		return dataaccess.getallCustomer();
	}

	@Override
	public BankCustomer getCustomerById(Integer id) {
		return dataaccess.getCustomerById(id);
	}

}
