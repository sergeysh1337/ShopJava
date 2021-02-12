package application;

public class Customer {
	private String userName;
	private String password;
	private String address;
	private String phoneNumber;
	private Cart personalCart;
	private boolean online;
	
	public Customer(String userName, String password, String address, String phoneNumber) {
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public void login()
	{
		online=true;
	}
	public void logout()
	{
		online=false;
	}
	public String getPhone()
	{
		return phoneNumber;
	}

	public Cart getPersonalCart() {
		return personalCart;
	}
	public void setPersonalCart(Cart personalCart) {
		this.personalCart = personalCart;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public String getPassword() {
		return password;
	}
	public String getAddress() {
		return address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
