package project.bank.edu.miu.asd.bank.service;

import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

import java.util.List;

public interface IBankCustomerService extends IComponent{
	public int createCustomer(BankCustomer customer);
	public List<BankCustomer> getallCustomer();
}
