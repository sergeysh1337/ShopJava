package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ShopManager {
	
	public Shop shop;
	public Customer loggedUser;
	public Book selectedBook;
	private Object Customer;
	private double dailyProfit = 0;
	private int countOfProductsSaled;
	
	
	public int getCountOfProductsSold() {
		return countOfProductsSaled;
	}

	public void setCountOfProductsSold() {
		this.countOfProductsSaled++;
	}

	public double getDailyProfit() {
		return dailyProfit;
	}

	public void setDailyProfit(double dailyProfit) {
		this.dailyProfit+=dailyProfit;
	}

	public ShopManager(String name) {
		this.shop = new Shop(name);
	}
	
	public void initBooks(){
		Book book;
		
	    book = new Book();
	    book.setName("Bridgerton");
	    book.setPrice(10.5);
	    book.setImgSrc("/assets/images/Bridgerton.jpg");
	    book.setColor("6A7324");
	    book.setSale(10);
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Atomic Habits");
	    book.setPrice(20);
	    book.setImgSrc("/assets/images/atomic-habits-2.jpg");
	    book.setColor("A7745B");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Bright Light");
	    book.setPrice(50);
	    book.setImgSrc("/assets/images/bright-light-star-carrier-book-8-1.jpg");
	    book.setColor("F16C31");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Elon Musk");
	    book.setPrice(29.50);
	    book.setImgSrc("/assets/images/elon-musk-15.jpg");
	    book.setColor("291D36");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Fly into the wind");
	    book.setPrice(9.99);
	    book.setImgSrc("/assets/images/fly-into-the-wind.jpg");
	    book.setColor("22371D");
	    book.setSale(10);
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Diamanti");
	    book.setPrice(25.99);
	    book.setImgSrc("/assets/images/i-diamanti-dei-cullingham.jpg");
	    book.setColor("FB5D03");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("I I knew then");
	    book.setPrice(10.99);
	    book.setImgSrc("/assets/images/if-i-knew-then-3.jpg");
	    book.setColor("80080C");
	    book.setSale(10);
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Morning Star");
	    book.setPrice(24.99);
	    book.setImgSrc("/assets/images/morning-star-47.jpg");
	    book.setColor("FFB605");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Outlander");
	    book.setPrice(8.50);
	    book.setImgSrc("/assets/images/outlander-16.jpg");
	    book.setColor("5F060E");
	    book.setSale(10);
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Reckless Road");
	    book.setPrice(9.50);
	    book.setImgSrc("/assets/images/reckless-road-1.jpg");
	    book.setColor("E7C00F");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Scorpion");
	    book.setPrice(22.99);
	    book.setImgSrc("/assets/images/scorpion-s-fury.jpg");
	    book.setColor("c8b6ff");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Secrets of the millionaire");
	    book.setPrice(10.50);
	    book.setImgSrc("/assets/images/secrets-of-the-millionaire-mind-2.jpg");
	    book.setColor("ffb5a7");
	    book.setSale(15);
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Shadow of night");
	    book.setPrice(20.99);
	    book.setImgSrc("/assets/images/shadow-of-night-2.jpg");
	    book.setColor("0466c8");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Silent voices");
	    book.setPrice(14.99);
	    book.setImgSrc("/assets/images/silent-voices-20.jpg");
	    book.setColor("cb997e");
	    book.setSale(20);
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Think again");
	    book.setPrice(27.50);
	    book.setImgSrc("/assets/images/think-again-18.jpg");
	    book.setColor("c77dff");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("The Institute");
	    book.setPrice(32.50);
	    book.setImgSrc("/assets/images/the-institute-14.jpg");
	    book.setColor("f9844a");
	    book.setSale(10);
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("This is gonna hurt");
	    book.setPrice(11.99);
	    book.setImgSrc("/assets/images/this-is-gonna-hurt-9.jpg");
	    book.setColor("735d78");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Year of yes");
	    book.setPrice(21.99);
	    book.setImgSrc("/assets/images/year-of-yes-2.jpg");
	    book.setColor("2ec4b6");
	    book.setSale(10);
	    shop.addBook(book);
		
	}

	public void initCustomerList() {
		Customer newCustomer;
		newCustomer= new Customer("user", "pass", "haifa23", "052145236");
		shop.addCustomer(newCustomer);
		
		newCustomer= new Customer("user1", "pass1", "haifa23", "052145237");
		shop.addCustomer(newCustomer);
		
		newCustomer= new Customer("user2", "pass2", "haifa23", "052145236");
		shop.addCustomer(newCustomer);
		
		newCustomer= new Customer("user3", "pass3", "haifa23", "052145236");
		shop.addCustomer(newCustomer);
		
		newCustomer= new Customer("user4", "pass4", "haifa23", "052145236");
		shop.addCustomer(newCustomer);
		
		newCustomer= new Customer("user5", "pass5", "haifa23", "052145236");
		shop.addCustomer(newCustomer);

	}
	public void initCartsList()
	{
		Cart newCart;
		for(int i=0;i<20;i++)
		{
			newCart=new Cart();
			shop.addCart(newCart);
		}

		
	}
	public void saveInFile(String fileName,String objectName) throws FileNotFoundException
	{
		File f=new File(fileName);
		PrintWriter pw=new PrintWriter(f);
		
		if(objectName.equals("Customer"))
		{
			Customer[] listToSave=Context.getInstance().currentShop().shop.getCustomers();
			for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)
			{
				pw.print(listToSave[i].toString());
				pw.print("\n");
			}
		}
		else if(objectName.equals("Book"))
		{
			Book[] listToSave=Context.getInstance().currentShop().shop.getAllBooks();
			for(int i=0;i<Context.getInstance().currentShop().shop.getProductCount();i++)
			{
				pw.print(listToSave[i].toString());
				pw.print("\n");
			}
		}
		else if(objectName.equals("Report"
				+ ""))
		{
			pw.println("Users:\n");	
			pw.println("Total Users:"+Context.getInstance().currentShop().shop.getCurrentCustomers());	
			pw.println("Online:"+Context.getInstance().currentShop().shop.getOnlineUsers());
			pw.println("Offline:"+Context.getInstance().currentShop().shop.getOfflineUsers()+"\n");
			
			pw.println("Books:\n");
			pw.println("Total books:"+Context.getInstance().currentShop().shop.getProductCount());	
			pw.println("Total books sold today:"+Context.getInstance().currentShop().getCountOfProductsSold());
			pw.println("Total money income:"+Context.getInstance().currentShop().dailyProfit+"\n");
			
			pw.println("Carts:\n");
			pw.println("Available Carts:"+Context.getInstance().currentShop().shop.getAvailableCarts());	
			pw.println("Busy carts:"+Context.getInstance().currentShop().shop.getBusyCarts());

		}
			pw.close();
			
			
	}
	public boolean updateListOfCustomers(Customer updatedCustomer)
	{
		Customer[] allCustomers=Context.getInstance().currentShop().shop.getCustomers();

		for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)
			if(allCustomers[i].getUserName().equals(updatedCustomer.getUserName()))
			{
				allCustomers[i]=updatedCustomer;
				break;
			}
		return true;
	}
	public boolean updateListOfBooks(Book updatedBook)
	{
		Book[] allBooks=Context.getInstance().currentShop().shop.getAllBooks();

		for(int i=0;i<Context.getInstance().currentShop().shop.getProductCount();i++)
			if(allBooks[i].getName().equals(updatedBook.getName()))
			{
				allBooks[i]=updatedBook;
				break;
			}
		return true;
	}
}

