package bos.service;

import java.util.List;

import javax.jws.WebService;

import bos.service.domain.Customer;

@WebService
public interface CustomerService {
	public List<Customer> findAll();
	public List<Customer> noAssociateCustomer();
	public List<Customer> hasAssociateCustomer(String id);
	public void associateCustomer(int[] customerIds,String decidedId);
	public Customer findCustomerByTelephone(String telephone);
	public String findCustomerIdByAddress(String address);
}
