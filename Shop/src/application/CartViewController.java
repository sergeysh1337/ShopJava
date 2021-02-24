package application;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class CartViewController{
	 

	    @FXML
	    private Label discount= new Label();

	    @FXML
	    private Label savedMoney= new Label();
	    @FXML
	    private Label isEmptyCart;
	    @FXML
	    private Label totalPrice = new Label();

	    @FXML
	    private Label afterDiscount;
	    @FXML
	    private Label saved;
	@FXML
	private ScrollPane scroll = new ScrollPane();
	@FXML
	private GridPane grid = new GridPane();
    @FXML
    private Button payBtn;

    @FXML
    private Button clearCart;

    @FXML
    private Button continueToShop;
    @FXML
    private GridPane gridBar;

    @FXML
    private HBox itemBar;
    @FXML
   	private ScrollPane scrollPanel;
	
	Book[] books = new Book[100];
	
	private MyListener myListener;
	
	public void getPrice() {
		
		double totalPriceBeforeSale = Context.getInstance().currentShop().loggedUser.getPersonalCart().totalPrice();
		double totalPriceAfterSale =totalPriceBeforeSale-Context.getInstance().currentShop().loggedUser.getPersonalCart().totalSale();
		totalPrice.setText(Double.toString(totalPriceBeforeSale));
		discount.setText(Double.toString(totalPriceAfterSale));
		savedMoney.setText(Double.toString(totalPriceBeforeSale-totalPriceAfterSale));
		}
	

	
	
	public void clearCart() {
		Context.getInstance().currentShop().loggedUser.getPersonalCart().deleteAll();
		System.out.println("all products removed");
		Alert afterMessage=new Alert(AlertType.INFORMATION);
		grid.setVisible(false);
		totalPrice.setText("0");
		discount.setText("0");
		savedMoney.setText("0");
		 //afterMessage.setTitle("Congratulations!");
		 afterMessage.setHeaderText("Cart is clear now!");
		 afterMessage.showAndWait();
	}
	public void deleteProduct(ActionEvent event)
	{
		
		
		String selectedBook=grid.getTypeSelector();
		System.out.println("dsadasdasd");
	
		
	}
	public void buy(ActionEvent event)
	{
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert afterAlert=new Alert(AlertType.INFORMATION);
		Alert errorAlert=new Alert(AlertType.ERROR);
		
		 Alert.setHeaderText("Are you sure you want to pay?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 if(Context.getInstance().currentShop().loggedUser.getPersonalCart().getCountOfProducts()!=0)
			 {
			 Context.getInstance().currentShop().loggedUser.pay(); 
			 afterAlert.setTitle("Congratulations");
			 afterAlert.setHeaderText("Paid successfully");
		
			 afterAlert.showAndWait();
			 Context.getInstance().currentShop().setDailyProfit(Double.valueOf(totalPrice.getText()));
			 Context.getInstance().currentShop().setCountOfProductsSold();
			
			grid.setVisible(false);
				totalPrice.setText("0");
				discount.setText("0");
				savedMoney.setText("0");
			 }
			 else
			 {
				 errorAlert.setHeaderText("Your cart is empty!");
			 errorAlert.showAndWait();
			 }
				 
		 }
	}
	
	public void viewCartProducts(){
		
	    books=Context.getInstance().currentShop().loggedUser.getPersonalCart().getAllProduct();
	    if(Context.getInstance().currentShop().loggedUser.getPersonalCart().getCountOfProducts()!=0)
	    {
	    int column = 0;
	    int row = 1;
	    try {
	    	
	        for (int i = 0; i < Context.getInstance().currentShop().loggedUser.getPersonalCart().getCountOfProducts(); i++) {
	            FXMLLoader fxmlLoader = new FXMLLoader();
	            fxmlLoader.setLocation(getClass().getResource("itemView.fxml"));
	            AnchorPane anchorPane = fxmlLoader.load();

	            ItemController itemController = fxmlLoader.getController();
	            itemController.setCartItem(books[i]);

	            if (column == 1) {
	                column = 0;
	                row++;
	            }

	            grid.add(anchorPane, column++, row); //(child,column,row)
	            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
	            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
	            grid.setMaxWidth(Region.USE_PREF_SIZE);

	            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
	            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
	            grid.setMaxHeight(Region.USE_PREF_SIZE);

	            GridPane.setMargin(anchorPane, new Insets(10));
	        	getPrice();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    }
	    else
	    	isEmptyCart.setText("Your cart is empty!!!");
	}
	
	public void backToShop() {
		continueToShop.getScene().getWindow().hide();
	}
}
