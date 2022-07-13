package project.bank.edu.miu.asd.bank.repository.impl;

import project.bank.edu.miu.asd.bank.domain.BankCustomer;
import project.bank.edu.miu.asd.bank.repository.BankDataAccess;
import project.bank.edu.miu.asd.bank.repository.IBankCustomerRepository;

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
	public void createCustomer(BankCustomer customer) {
		
		dataaccess.SaveCustomer(customer);
	}

}
