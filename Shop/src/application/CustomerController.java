package application;

public class CustomerController {
	
	public void createNewCustomer(String uName, String pwd, String adr, String phone)
	{
		Customer newCustomer = new Customer();
		
		newCustomer.setUserName(uName);
		newCustomer.setPassword(pwd);
		newCustomer.setAddress(adr);
		newCustomer.setPhone(phone);
		Customer[] custList = new Customer[] {newCustomer};
		Shop customerList = new Shop(custList);
	}

}
