package application;

public class Shop {
	private String shopName;
	private Book[] allProducts;
	private Customer[] allCustomers;
	private int currentCustomers;
	private Cart[] allCarts;  
	
	public Cart[] getAllCarts() {
		return allCarts;
	}
	
	private int currentCarts;
	private int productCount;

	public String show()
	{
		String showAll="";
		for(int i=0; i<currentCustomers; i++)
		showAll+=allCustomers[i].toString()+"\n";
			return showAll;
	}
	public String showBooks()
	{
		String showAll="";
		for(int i=0; i<productCount; i++)
		showAll+=allProducts[i].toString()+"\n";
			return showAll;
	}
public int getCurrentCarts()
{
	return currentCarts;
}
	
	public int getProductCount() {
		return productCount;
	}


	public int getCurrentCustomers() {
		return currentCustomers;
	}


	public void setCurrentCustomers(int currentCustomers) {
		this.currentCustomers = currentCustomers;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public Shop(String shopName) {
		this.shopName = shopName;
		this.allProducts = new Book[100];
		this.allCustomers =new Customer[100];
		this.allCarts = new Cart[100];	
	}

	
	public void addCustomer(Customer newCustomer)
	{
		if(currentCustomers<100)
		{
			allCustomers[currentCustomers++]=newCustomer;
		}
	}
	
	public void addBook(Book newBook)
	{
		if(productCount<100)
		{
			allProducts[productCount++]=newBook;
		}
	}
	

	public Customer[] getCustomers()
	{
		return this.allCustomers;
	}
	
	
	public Book[] getAllBooks()
	{
		return this.allProducts;
	}
	
	public void deleteCustomer(Customer deleteCustomer)
	{
		Customer[] anotherArray = new Customer[100]; 
		for(int i=0,k=0;i<currentCustomers;i++)
		{
			if(allCustomers[i].getUserName().equals(deleteCustomer.getUserName()))
				continue;
			
				anotherArray[k++]=allCustomers[i];
		}
		allCustomers=anotherArray;
		currentCustomers--;
	}
	public void deleteBook(Book deleteBook)
	{
		Book[] anotherArray = new Book[100]; 
		for(int i=0,k=0;i<productCount;i++)
		{
			if(allProducts[i].getName().equals(deleteBook.getName()))
				continue;
			
				anotherArray[k++]=allProducts[i];
		}
		allProducts=anotherArray;
		productCount--;
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
	public int getAvailableCarts()
	{
		int availableCarts = 0;
		for(int i=0;i<currentCarts;i++)
		{
			if(allCarts[i].getOwner()==null)
				availableCarts++;
				
		}
		return availableCarts;
	}
	public int getBusyCarts()
	{
		int busyCarts = 0;
		for(int i=0;i<currentCarts;i++)
		{
			if(allCarts[i].getOwner()!=null)
				busyCarts++;
				
		}
		return busyCarts;
	}
	public int getOnlineUsers()
	{
		int onlineUsers=0;
		for(int i=0;i<currentCustomers;i++)
		{
			if(allCustomers[i].getStatus()==true)
				onlineUsers++;
		}
		return onlineUsers;
	}
	public int getOfflineUsers()
	{
		
		return currentCustomers-getOnlineUsers();
	}
}
