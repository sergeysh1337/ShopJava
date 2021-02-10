package application;

public class Customer {
	private String userName;
	private String password;
	private String address;
	private String phoneNumber;
	private Cart personalCart;
	private boolean online;
	
	public Customer(String userName, String password, String address, String string) {
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNumber = string;
	}
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void login()
	{
		online=true;
	}
	public void logout()
	{
		online=false;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setPhone(String phoneNumber)
	{
		this.phoneNumber=phoneNumber;
	}
	public void takeCart(Cart newCart)
	{
		personalCart=newCart;
	}
	public void releaseCart()
	{
		personalCart=null;
	}
	public void addProduct(Product newProduct)
	{
		personalCart.addProduct(newProduct);
	}
	public void deleteProduct()
	{
		
	}
	public void showInvoice()
	{
		System.out.println(personalCart.totalPrice());
	}
	public void pay(double sum)
	{
		
			personalCart.deleteAll();
			personalCart=null;
		
		
	}
	public boolean getStatus()
	{
		return online;
	}
	
}
