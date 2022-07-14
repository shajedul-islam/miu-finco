package project.bank.edu.miu.asd.bank.repository;

import domain.impl.Customer;
import ioc.IComponent;
import project.bank.edu.miu.asd.bank.domain.BankCustomer;

import java.util.List;

public interface IBankCustomerRepository extends IComponent {

	public void save(BankCustomer customer);
	public List<BankCustomer> getallCustomer();

	public BankCustomer getCustomerById(Integer id);
}
