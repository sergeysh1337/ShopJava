package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController{

	@FXML
	private TextField userName;

	@FXML
	private TextField pwd;

	@FXML
	private TextField phone;

	@FXML
	private TextField address;

	@FXML
	private Button create;
	@FXML
	private Label lblStatus;
	@FXML
	private Button Login;
	@FXML
	private TextField txtUserName;
	@FXML
	private TextField txtPassword;
	
	    public void checkLogin(ActionEvent event) throws Exception
	    {
	    	if(Context.getInstance().currentShop().shop.getProductCount()== 0)
	    		{Context.getInstance().currentShop().initCustomerList();}
	    	
		    
		    	Customer[] tempCustomers;
		    	tempCustomers=Context.getInstance().currentShop().shop.getCustomers();
		    	for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)		
		    	{
		    		if(tempCustomers[i].getUserName().equals(txtUserName.getText()) 
		    				&& tempCustomers[i].getPassword().equals(txtPassword.getText()))
		    		{
		    			lblStatus.setText("Login Success");
		    			tempCustomers[i].login();
		    			changeScene("Main.fxml", event);
		    			 break;
		    		}
		    		else
		    			lblStatus.setText("Login failed, please try again");	
		    	}
	    	
	    }
	    
	    public void signUp(ActionEvent event) throws Exception
	    {
	    	changeScene("SignUp.fxml", event);
	    	
	    }
	    
	    public void createNewCustomer(ActionEvent event) throws Exception{
	    	if(Context.getInstance().currentShop().shop.getProductCount()== 0)
    		{Context.getInstance().currentShop().initCustomerList();}
	    	Customer newCustomer;
	    	newCustomer= new Customer(userName.getText(), pwd.getText(), phone.getText(), address.getText());
	    	Context.getInstance().currentShop().shop.addCustomer(newCustomer);
	    	System.out.println("I'm after adding customer to array of obj\n");
	    	Context.getInstance().currentShop().shop.show();
	    	changeScene("Login.fxml", event);
	    }
	    
	    public void changeScene(String path, ActionEvent event) throws IOException {
	    	Parent viewParent = FXMLLoader.load(getClass().getResource(path));
	        Scene viewScene = new Scene(viewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(viewScene);
	        window.show();
	    }
	   
}
