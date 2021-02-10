package application;

public class Shop {
	private String shopName;
	private Book[] allProducts;
	private int currentProducts;
	private Customer[] allCustomers;
	private int currentCustomers;
	private Cart[] allCarts;  
	private int currentCarts;

	public Shop(Customer[] allCustomers) {
		//this.shopName = shopName;
		//this.allProducts = allProducts;
		this.allCustomers = allCustomers;
		//this.allCarts = allCarts;
		//currentProducts=allProducts.length-1;
		currentCustomers=allCustomers.length;
		//currentCarts=allCarts.length-1;
		
	}
	
	public void addCustomer(Customer newCustomer)
	{
		if(currentCustomers<100)
		{
			allCustomers[currentCustomers++]=newCustomer;
		}
	}
	

	public Customer[] getCustomers()
	{
		return this.allCustomers;
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
	public int numOfCartsInUse()
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
