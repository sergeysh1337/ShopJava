package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;
    @FXML
    private Label discountLable = new Label();
    @FXML
    private VBox vBox = new VBox();
    @FXML
    private ImageView img;

    @FXML
    private Button removeBtn;
    @FXML
	private GridPane grid = new GridPane();
    @FXML
    private AnchorPane Apane;
    @FXML
    private void click(MouseEvent mouseEvent) {
    	if(myListener != null)
    		myListener.onClickListener(book);
    }

    private Book book;
    private MyListener myListener;

    public void setData(Book book, MyListener myListener) {
        this.book = book;
        double priceAfterSale =book.getPriceAfterSale(); 
        this.myListener = myListener;
        nameLabel.setText(book.getName());
        priceLable.setText(Main.CURRENCY + book.getPrice());
        if(book.getSale() !=0 ) {
        	discountLable.setText(Main.CURRENCY +priceAfterSale);
        }
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
        
    }
    
    public void setCartItem(Book book) {
        this.book = book;
        double priceAfterSale =book.getPriceAfterSale(); 
        this.myListener = myListener;
        nameLabel.setText(book.getName());
        priceLable.setText(Main.CURRENCY + book.getPrice());
        if(book.getSale() !=0 )
        	discountLable.setText(Main.CURRENCY +priceAfterSale);
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
        removeBtn.setVisible(true);
        
    }
    
    public void removeItem(){
    	System.out.println(nameLabel.getText());
    	CartViewController cartCtrl = new CartViewController();
    	
    	Apane.setVisible(false);
    	Book[] books = Context.getInstance().currentShop().loggedUser.getPersonalCart().getAllProduct();
    	int counOfProduct = Context.getInstance().currentShop().loggedUser.getPersonalCart().getCountOfProducts();
    	for(int i=0; i< counOfProduct; i++)
    		if(books[i].getName().equals(nameLabel.getText()))
    		{
    			Context.getInstance().currentShop().loggedUser.getPersonalCart().deleteProduct(books[i]);
    			Apane.setVisible(false);
    			
    			break;
    		}
    	Context.getInstance().currentShop().loggedUser.getPersonalCart().showCart();
    	cartCtrl.getPrice();
    	
    }
    
    
}
