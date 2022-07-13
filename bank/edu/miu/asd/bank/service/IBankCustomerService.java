package project.bank.edu.miu.asd.bank.service;

import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

public interface IBankCustomerService extends IComponent{
	public void createCustomer(BankCustomer customer);
}
