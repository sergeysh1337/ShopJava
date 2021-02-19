package application;

public class ShopManager {
	
	public Shop shop;
	
	
	public ShopManager(String name) {
		this.shop = new Shop(name);
	}
	
	public void initBooks(){
		Book book;
		
	    book = new Book();
	    book.setName("Bridgerton");
	    book.setPrice(2.99);
	    book.setImgSrc("/assets/images/Bridgerton.jpg");
	    book.setColor("6A7324");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Atomic Habits");
	    book.setPrice(3.99);
	    book.setImgSrc("/assets/images/atomic-habits-2.jpg");
	    book.setColor("A7745B");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Bright Light");
	    book.setPrice(1.50);
	    book.setImgSrc("/assets/images/bright-light-star-carrier-book-8-1.jpg");
	    book.setColor("F16C31");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Elon Musk");
	    book.setPrice(0.99);
	    book.setImgSrc("/assets/images/elon-musk-15.jpg");
	    book.setColor("291D36");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Fly into the wind");
	    book.setPrice(4.99);
	    book.setImgSrc("/assets/images/fly-into-the-wind.jpg");
	    book.setColor("22371D");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Diamanti");
	    book.setPrice(2.99);
	    book.setImgSrc("/assets/images/i-diamanti-dei-cullingham.jpg");
	    book.setColor("FB5D03");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("I I knew then");
	    book.setPrice(0.99);
	    book.setImgSrc("/assets/images/if-i-knew-then-3.jpg");
	    book.setColor("80080C");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Morning Star");
	    book.setPrice(0.99);
	    book.setImgSrc("/assets/images/morning-star-47.jpg");
	    book.setColor("FFB605");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Outlander");
	    book.setPrice(0.99);
	    book.setImgSrc("/assets/images/outlander-16.jpg");
	    book.setColor("5F060E");
	    shop.addBook(book);

	    book = new Book();
	    book.setName("Reckless Road");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/reckless-road-1.jpg");
	    book.setColor("E7C00F");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Scorpion");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/scorpion-s-fury.jpg");
	    book.setColor("c8b6ff");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Secrets of the millionaire");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/secrets-of-the-millionaire-mind-2.jpg");
	    book.setColor("ffb5a7");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Shadow of night");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/shadow-of-night-2.jpg");
	    book.setColor("0466c8");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Silent voices");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/silent-voices-20.jpg");
	    book.setColor("cb997e");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Think again");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/think-again-18.jpg");
	    book.setColor("c77dff");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("The Institute");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/the-institute-14.jpg");
	    book.setColor("f9844a");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("This is gonna hurt");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/this-is-gonna-hurt-9.jpg");
	    book.setColor("735d78");
	    shop.addBook(book);
	    
	    book = new Book();
	    book.setName("Year of yes");
	    book.setPrice(1.99);
	    book.setImgSrc("/assets/images/year-of-yes-2.jpg");
	    book.setColor("2ec4b6");
	    shop.addBook(book);
	    
	    //return shop.getAllBooks();
		
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
		//return shop.getCustomers();
	}
	

	
}
