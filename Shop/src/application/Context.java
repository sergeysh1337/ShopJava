package application;

public class Context {
	  private final static Context instance = new Context();

	    public static Context getInstance() {
	        return instance;
	    }
	  private ShopManager MyShop= new ShopManager("Book store");
	  public ShopManager currentShop() {
		 
		  return MyShop;
	  }

	  

}
