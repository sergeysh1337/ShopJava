package application;

public class Shop {
	private String shopName;
	private Book[] allProducts;
	private int currentProducts;
	private Customer[] allCustomers;
	private int currentCustomers;
	private Cart[] allCarts;  
	private int currentCarts;
	private int productCount;

	public void show()
	{
		for(int i=0; i<currentCustomers; i++)
		System.out.println(allCustomers[i].getAddress()+" "+allCustomers[i].getUserName()+" "
		+allCustomers[i].getPassword()+" "+allCustomers[i].getPhone());
		System.out.println("\n");
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
