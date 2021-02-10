package application;

public class Shop {
	private String shopName;
	private Product[] allProducts;
	private int currentProducts;
	private Customer[] allCustomers;
	private int currentCustomers;
	private Cart[] allCarts;  
	private int currentCarts;

	public Shop() {
		this.shopName = shopName;
		this.allProducts = new Product[100];
		this.allCustomers =new Customer[100];
		this.allCarts = new Cart[100];
		
		
	}
	public Product[] getAllProducts()
	{
		return allProducts;
	}
	public Customer[] getAllCustomers()
	{
		return allCustomers;
	}
	public void addCustomer(Customer newCustomer)
	{
		if(currentCustomers<100)
		{
			allCustomers[currentCustomers++]=newCustomer;
		}
	}
	public void deleteCustomer(Customer deleteCustomer)
	{
		Customer[] anotherArray = new Customer[currentCustomers - 1]; 
		for(int i=0,k=0;i<currentCustomers;i++)
		{
			if(allCustomers[i] == deleteCustomer)
				continue;
			
				anotherArray[k++]=allCustomers[i];
		}
		allCustomers=anotherArray;
		currentCustomers--;
	}
	
	public void addCart(Cart newCart)
	{
		if(currentCarts<100)
		{
			allCarts[currentCarts++]=newCart;
		}
	}
	public void deleteCart(Cart deleteCart)
	{
		Cart[] anotherArray = new Cart[currentCarts - 1]; 
		for(int i=0,k=0;i<currentCarts;i++)
		{
			if(allCarts[i] == deleteCart)
				continue;
			
				anotherArray[k++]=allCarts[i];
		}
		allCarts=anotherArray;
		currentCarts--;
	}
	public int numOfOnlineCustomers()
	{
		int onlineCustomers=0;
		for(int i=0;i<currentCustomers;i++)
		{
			if(allCustomers[i].getStatus()==true)
				onlineCustomers++;
		}
		return onlineCustomers;
	}
	public int numOfCartsUsing()
	{
		int cartsUsing=0;
		for(int i=0;i<currentCarts;i++)
		{
			if(allCarts[i].getStatus()==true)
				cartsUsing++;
		}
		return cartsUsing;
	}
	

}
