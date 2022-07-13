package project.bank.edu.miu.asd.bank.repository;

import domain.impl.Customer;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

public interface IBankCustomerRepository extends IComponent {

	public void createCustomer(BankCustomer customer);
}