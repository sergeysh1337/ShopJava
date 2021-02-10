package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;




public class Main extends Application {
	 public static final String CURRENCY = "$";
	@Override
	public void start(Stage primaryStage) {
		try {
			 Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		        primaryStage.setTitle("Book store");
		        primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		CustomerController custCntr = new CustomerController();
		custCntr.createNewCustomer("user", "pass", "Peer 76", "0521452365");
		
//		Customer newCustomer = new Customer();
//		
//		newCustomer.setUserName("user");
//		newCustomer.setPassword("pass");
//		newCustomer.setAddress("Peer 76");
//		newCustomer.setPhone("052639636");
//		Customer[] custList = new Customer[] {newCustomer};
//		Shop customerList = new Shop(custList);
//		
//		Customer newCustomer2 = new Customer();
//		newCustomer2.setUserName("user1");
//		newCustomer2.setPassword("pass1");
//		newCustomer2.setAddress("Peer 762");
//		newCustomer2.setPhone("052639622");
//		customerList.addCustomer(newCustomer2);
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
