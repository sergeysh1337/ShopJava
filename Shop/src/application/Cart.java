package application;

import java.util.Arrays;

public class Cart {
	private int numberOfCart;
	private Product[] products;
	private int countOfProducts;
	private Customer cartOwner;
	
	public void addProduct(Product newProduct)
	{
		if(countOfProducts<100)
		{
			products[countOfProducts]=newProduct;
			countOfProducts++;
		}
	}
	
	public void deleteProduct(Product deleteProduct)
	{
		Product[] anotherArray = new Product[countOfProducts - 1]; 
		for(int i=0,k=0;i<countOfProducts;i++)
		{
			if(products[i] == deleteProduct)
				continue;
			
				anotherArray[k++]=products[i];
		}
		products=anotherArray;
		countOfProducts--;
	}
	public void deleteAll()
	{
		for(int i=0;i<countOfProducts;i++)
		
			products[i]=null;
		
	}
	public void showCart()
	{
		System.out.println(Arrays.toString(products));

	}
	public double totalPrice()
	{
		double totalPrice = 0;
		for(int i=0;i<countOfProducts;i++)
		{
			totalPrice+=products[i].getPrice();
		}
		return totalPrice;
	}
	public double totalSale()
	{
		double totalSale = 0;
		for(int i=0;i<countOfProducts;i++)
		{
			totalSale+=products[i].getPrice()*products[i].getSale()/100;
		}
		return totalSale;
	}
	public boolean getStatus()
	{
		return cartOwner!=null;
	}
}
