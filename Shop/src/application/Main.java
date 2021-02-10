package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;




public class Main extends Application {
	 public static final String CURRENCY = "$";
	 @FXML
	 private Label lblStatus;
	 @FXML
	 private TextField txtUserName;
	 @FXML
	 private TextField txtPassword;
	 @FXML
	 public Label myLabel;
	 Shop bookShop;
	
	 	
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		        primaryStage.setTitle("Book store");
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
				
		        Customer Customer1=new Customer("Sergey123","password","arlozorov 5","0546785645");
				Customer Customer2=new Customer("Aika123","password123","arlozorov 25","054456443");
				Customer Customer3=new Customer("dfg123","password123","arlozorov 25","054456443");
				
				Product product1=new Product("bridgerton",250,50,1000);
				Product product2=new Product("war and peace",300,30,1001);
				Cart cart1=new Cart(1000);
				Cart cart2=new Cart(1001);
				Customer[] customers=new Customer[] {Customer1,Customer2};
				Product[] products=new Product[] {product1,product2};
			Cart[] carts=new Cart[] {cart1,cart2};
				
				bookShop=new Shop();
				bookShop.addCustomer(Customer3);
				bookShop.addCustomer(Customer2);
				bookShop.addCustomer(Customer1);
				System.out.println(Customer1.getUserName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
	
	public static void main(String[] args) {
		launch(args);

	}
}
