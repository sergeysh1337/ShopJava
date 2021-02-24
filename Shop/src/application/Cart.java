
package application;

import java.util.Arrays;

public class Cart {
	private static int autoNumber=1000;
	private int numberOfCart;
	private Book[] books;
	private int countOfProducts;
	private Customer cartOwner;
	public Cart()
	{
		numberOfCart=autoNumber++;
		books=new Book[100];
	}
	public int getNumberOfCart()
	{
		return numberOfCart;
	}
	public int getCountOfProducts() {
		return countOfProducts;
	}

	public void setCountOfProducts(int countOfProducts) {
		this.countOfProducts = countOfProducts;
	}

	
	/*public Cart()
	{
		books = new Book[1000];
		numberOfCart++;
	}*/
	
	public Book[] getAllProduct() {
		return this.books;
	}
	public void addProduct(Book newProduct)
	{
		if(countOfProducts<100)
		{
			books[countOfProducts]=newProduct;
			countOfProducts++;
		}
	}
	
	public void deleteProduct(Book deleteProduct)
	{
		Book[] anotherArray = new Book[100]; 
		for(int i=0,k=0;i<countOfProducts;i++)
		{
			if(books[i] == deleteProduct)
				continue;
			
				anotherArray[k++]=books[i];
		}
		books=anotherArray;
		countOfProducts--;
	}
	public void deleteAll()
	{
		for(int i=0;i<countOfProducts;i++)
		
			books[i]=null;
		countOfProducts=0;
		
	}
	public void showCart()
	{
		System.out.println(Arrays.toString(books));

	}
	public double totalPrice()
	{
		
		double totalPrice = 0;
		
		for(int i=0;i<countOfProducts;i++)
		{
			totalPrice+=books[i].getPrice();
		}
		
		return Math.round(totalPrice);
		
	}
	public double totalSale()
	{
		double totalSale = 0;
		for(int i=0;i<countOfProducts;i++)
		{
			totalSale+=books[i].getPrice()*books[i].getSale()/100;
		}
		return Math.round(totalSale);
	}
	public boolean getStatus()
	{
		return cartOwner!=null;
	}
	public Customer getOwner()
	{
		return cartOwner;
	}
	public void setOwner(Customer cartOwner)
	{
		this.cartOwner=cartOwner;
	}
	public int getCartNumber()
	{
		return numberOfCart;
	}
}
