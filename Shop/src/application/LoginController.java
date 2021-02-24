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
    @FXML
    private Label nameChange = new Label();

    @FXML
    private TextField pwdChange= new TextField();

    @FXML
    private TextField phoneChange= new TextField();

    @FXML
    private TextField addressChange= new TextField();
    @FXML
    private Button closeMyProfile;
    @FXML
    private Button saveChanges;
    @FXML
	private Label isSaved;
    private Boolean isInEditMode=false;
	
	    public void checkLogin(ActionEvent event) throws Exception
	    {
	    	if(Context.getInstance().currentShop().shop.getProductCount()== 0)
	    		{
	    		
	    		Context.getInstance().currentShop().initBooks();
	    		}
	    	if(Context.getInstance().currentShop().shop.getCurrentCustomers()== 0)
	    		{
	    		Context.getInstance().currentShop().initCustomerList();
	    		}
	    	if(Context.getInstance().currentShop().shop.getCurrentCarts()== 0)
    		{
    		Context.getInstance().currentShop().initCartsList();
    		}
	    	for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCarts();i++)
	    	{
	    		System.out.println((Context.getInstance().currentShop().shop.getAllCarts())[i].getNumberOfCart());	
	    	}
	    	
		    	if(txtUserName.getText().equals("admin"))
		    	{
		    		changeScene("AdminPage.fxml", event);
		    	return;
		    	}
		    	Customer[] tempCustomers;
		    	Cart[] allCarts;
		    	allCarts=Context.getInstance().currentShop().shop.getAllCarts();
		    	tempCustomers=Context.getInstance().currentShop().shop.getCustomers();
		    	for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)		
		    	{
		    		if(tempCustomers[i].getUserName().equals(txtUserName.getText()) 
		    				&& tempCustomers[i].getPassword().equals(txtPassword.getText()))
		    		{
		    			lblStatus.setText("Login Success");
		    			tempCustomers[i].login();
		    			for(int j=0;j<Context.getInstance().currentShop().shop.getCurrentCarts();j++)
		    			{
		    				if(allCarts[j].getOwner()==null) {
		    					tempCustomers[i].takeCart(allCarts[j]);
		    					break;
		    				}
		    				
		    			}

		    			
		    			Context.getInstance().currentShop().loggedUser = tempCustomers[i];
		    			
		    			changeScene("Main.fxml", event);
		    			 break;
		    		}
		    		else
		    			lblStatus.setText("Login failed, please try again");	
		    	}
	    	
	    }
	    
	    public void retriveCustomerInfo() throws IOException {
	         nameChange.setText(Context.getInstance().currentShop().loggedUser.getUserName());
	         nameChange.disabledProperty();
	         pwdChange.setText(Context.getInstance().currentShop().loggedUser.getPassword());
	         phoneChange.setText(Context.getInstance().currentShop().loggedUser.getPhone());
	         addressChange.setText(Context.getInstance().currentShop().loggedUser.getAddress());
	    }
	    
	    public void signUp(ActionEvent event) throws Exception
	    {
	    	
	    	changeScene("SignUp.fxml", event);
	    	
	    }
	    
	    public void createNewCustomer(ActionEvent event) throws Exception{
	    	if(Context.getInstance().currentShop().shop.getProductCount()== 0)
    		{Context.getInstance().currentShop().initCustomerList();}
	    	Customer newCustomer;
	    	adminController controller=new adminController();
	    	newCustomer= new Customer(userName.getText(), pwd.getText(), address.getText(), phone.getText());
	    	if(isInEditMode == true)
	    	{
	    		
	    		Customer[] tempCustomers=Context.getInstance().currentShop().shop.getCustomers();
	    		
	    		for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)
	    		{
	    			if(userName.getText().equals(tempCustomers[i].getUserName()))
	    			{
	    			tempCustomers[i]=newCustomer;
	    			break;
	    			}
	    			
	    		}
	    		System.out.println("new array of customers");
	    		System.out.println(Context.getInstance().currentShop().shop.show());
	    		isInEditMode=false;
   			 changeScene("AdminPage.fxml",event);
	    		
	    	}
	    	else
	    	{
	    	Context.getInstance().currentShop().shop.addCustomer(newCustomer);
	    	System.out.println("I'm after adding customer to array of obj\n");
	    	System.out.println(Context.getInstance().currentShop().shop.show());
	    	changeScene("Login.fxml", event);
	    	}
	    	
	    }
	    
	    

		
		public void saveChanges(ActionEvent event) throws Exception{
	    	String userInfoToChange = Context.getInstance().currentShop().loggedUser.getUserName();
	    	Customer[] tempCustomers;
	    	tempCustomers=Context.getInstance().currentShop().shop.getCustomers();
	    	for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)		
	    	{
	    		if(tempCustomers[i].getUserName().equals(userInfoToChange))
	    		{
	    			tempCustomers[i].setPassword(pwdChange.getText());
	    			tempCustomers[i].setAddress(addressChange.getText());
	    			tempCustomers[i].setPhone(phoneChange.getText());
	    			Context.getInstance().currentShop().loggedUser=tempCustomers[i];
	    			isSaved.setText("Your changes saved!");
	    			System.out.println("I'm after changes\n");
	    	    	Context.getInstance().currentShop().shop.show();
	    	    	
	    			break;
	    			
	    		}
	    		
	    	}
	    }
	    
	    public void closeMyProfile() {
	    	closeMyProfile.getScene().getWindow().hide();
	    }
	    public void changeScene(String path, ActionEvent event) throws IOException {
	    	Parent viewParent = FXMLLoader.load(getClass().getResource(path));
	        Scene viewScene = new Scene(viewParent);
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(viewScene);
	        window.show();
	    }
	    public void inflateUI(Customer customer)
	    {
	    	userName.setText(customer.getUserName());
	    	pwd.setText(customer.getPassword());
	    	phone.setText(customer.getPhone());
	    	address.setText(customer.getAddress());
	    	userName.setEditable(false);
	    	isInEditMode=true;

	    }
	   
}
