package application;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.sun.glass.ui.Window.Level;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.converter.DoubleStringConverter;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
public class adminController implements Initializable {
	
	@FXML
	private Label availableCarts;
	@FXML
	private Label busyCarts;
	@FXML
	private Label onlineUsers;
	@FXML
	private Label offlineUsers;
	@FXML
	private Label totalUsers;
	@FXML
	private Label totalBooks;
	@FXML
	private Label totalSold;
	@FXML
	private Label income;
	@FXML
	private TableView<Customer> customersTable;
	@FXML
	private Button deleteButton;
	@FXML
	private Button updateButton;
	@FXML
	private Button create=new Button();
	@FXML
	private TableView<Book> booksTable;
	@FXML
	private TableView<Cart> cartsTable;

	@FXML
	private MenuItem delete;
	@FXML
	private MenuItem edit;
	@FXML
	private TableColumn<Customer,String> userName;
	@FXML
	ObservableList<Customer> customersList=FXCollections.observableArrayList();
	@FXML
	ObservableList<Book> bookList=FXCollections.observableArrayList();
	@FXML
	ObservableList<Cart>cartList=FXCollections.observableArrayList();
	@FXML
	private TableColumn<Customer,String> pwd;
	@FXML
	private TableColumn<Customer,Boolean> status;
	@FXML
	private TableColumn<Customer,String> address;
	@FXML
	private TableColumn<Customer,String> phone;
	@FXML
	private TableColumn<Customer,Cart> numberOfCart;
	
	@FXML
	private TableColumn<Cart,Integer> cartNumber;
	@FXML
	private TableColumn<Cart,String> cartOwner;
	
	@FXML
	private TableColumn<Book,String> bookName;
	@FXML
	private TableColumn<Book,Double> price;
	@FXML
	private TableColumn<Book,Double> sale;
	@FXML
	private TableColumn<Book,Integer> numOfCatalog;
	@FXML 
	private TableView<String> reportsTable;
	

	@FXML
	public void deleteCustomer(ActionEvent event)
	
	{
		System.out.println("before deletion of customer\n");
		Context.getInstance().currentShop().shop.show();
		Alert AlertMaker=new Alert(AlertType.ERROR);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert afterMessage=new Alert(AlertType.INFORMATION);

		Customer selectedForDeletion=customersTable.getSelectionModel().getSelectedItem();
		if(selectedForDeletion==null)
		{
			 AlertMaker.setTitle("Error");
			 AlertMaker.setContentText("No Customer selected");
			 return;
		}
		Alert.setTitle("Deleting Customer");
		 Alert.setContentText("Are you sure you want to delete "+selectedForDeletion.getUserName()+"?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 customersList.remove(selectedForDeletion);
			 customersTable.setItems(customersList);
			 afterMessage.setContentText("Customer was succesfully deleted");
			 afterMessage.showAndWait();

			Context.getInstance().currentShop().shop.deleteCustomer(selectedForDeletion);
			System.out.println("after deletion\n");

			Context.getInstance().currentShop().shop.show();
			totalUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getCurrentCustomers()));
			offlineUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getOfflineUsers()));
			onlineUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getOnlineUsers()));


		 }
	
    	
	}
	public void deleteCart(ActionEvent event)
	{
		
		Alert AlertMaker=new Alert(AlertType.ERROR);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert afterMessage=new Alert(AlertType.INFORMATION);
		Cart selectedForDeletion=cartsTable.getSelectionModel().getSelectedItem();
		if(selectedForDeletion==null)
		{
			 AlertMaker.setTitle("Error");
			 AlertMaker.setContentText("No cart selected");
			 return;
		}
		Alert.setTitle("Deleting cart");
		 Alert.setContentText("Are you sure you want to delete cart: "+selectedForDeletion.getCartNumber()+"?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 cartList.remove(selectedForDeletion);
			 cartsTable.setItems(cartList);
			 afterMessage.setContentText("Cart was succesfully deleted");
			 afterMessage.showAndWait();
			Context.getInstance().currentShop().shop.deleteCart(selectedForDeletion);
			availableCarts.setText(String.valueOf(Context.getInstance().currentShop().shop.getAvailableCarts()));

				

		 }
	}
	public void deleteBook(ActionEvent event)
	{
		System.out.println("before deletion of book\n");
		System.out.println(Context.getInstance().currentShop().shop.show());
		Alert AlertMaker=new Alert(AlertType.ERROR);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert afterMessage=new Alert(AlertType.INFORMATION);
		Book selectedForDeletion=booksTable.getSelectionModel().getSelectedItem();
		if(selectedForDeletion==null)
		{
			 AlertMaker.setTitle("Error");
			 AlertMaker.setContentText("No book selected");
			 return;
		}
		Alert.setTitle("Deleting book");
		 Alert.setContentText("Are you sure you want to delete "+selectedForDeletion.getName()+"?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 bookList.remove(selectedForDeletion);
			 booksTable.setItems(bookList);
			 afterMessage.setContentText("Book was succesfully deleted");
			 afterMessage.showAndWait();

			Context.getInstance().currentShop().shop.deleteBook(selectedForDeletion);
			totalBooks.setText(String.valueOf(Context.getInstance().currentShop().shop.getProductCount()));
			System.out.println("after deletion\n");

			System.out.println(Context.getInstance().currentShop().shop.show());
				

		 }
	}
	public void changePwdOfCustomer(CellEditEvent<Customer,String> event)
	{
		Alert updateInfo=new Alert(AlertType.INFORMATION);
		boolean isUpdated;
		System.out.println("im in pwdchange");
		Customer selected=customersTable.getSelectionModel().getSelectedItem();
		selected.setPassword(event.getNewValue().toString());
		isUpdated=Context.getInstance().currentShop().updateListOfCustomers(selected);
		if(isUpdated == true)
		{
			updateInfo.setTitle("Important message");
			updateInfo.setContentText("Details was successfully updated!");
			updateInfo.showAndWait();
			availableCarts.setText(String.valueOf((Context.getInstance().currentShop().shop.getAvailableCarts())));
		System.out.println("after update\n");

		System.out.println(Context.getInstance().currentShop().shop.show());
		}
	}
	public void changePriceOfBook(CellEditEvent<Book,Double> event)
	{
		Alert updateInfo=new Alert(AlertType.INFORMATION);
		System.out.println("im in price change");
		boolean isUpdated;
		Book selected=booksTable.getSelectionModel().getSelectedItem();
		selected.setPrice((event.getNewValue()));
		isUpdated=Context.getInstance().currentShop().updateListOfBooks(selected);
		if(isUpdated == true)
		{
			updateInfo.setTitle("Important message");
			updateInfo.setContentText("Details was successfully updated!");
			updateInfo.showAndWait();
		System.out.println("after update\n");

		System.out.println(Context.getInstance().currentShop().shop.showBooks());
		}
		
	}	
	
	public void changeSaleOfBook(CellEditEvent<Book,Double> event)
{
	Alert updateInfo=new Alert(AlertType.INFORMATION);
	System.out.println("im in price change");
	boolean isUpdated;
	Book selected=booksTable.getSelectionModel().getSelectedItem();
	selected.setSale((event.getNewValue()));
	isUpdated=Context.getInstance().currentShop().updateListOfBooks(selected);
	if(isUpdated == true)
	{
		updateInfo.setTitle("Important message");
		updateInfo.setContentText("Details was successfully updated!");
		updateInfo.showAndWait();
	System.out.println("after update\n");

	System.out.println(Context.getInstance().currentShop().shop.showBooks());
	}
}
	
	
	public void changeAddressOfCustomer(CellEditEvent<Customer,String> event)
	{
		Alert updateInfo=new Alert(AlertType.INFORMATION);
		System.out.println("im in addresschange");
		boolean isUpdated;
		Customer selected=customersTable.getSelectionModel().getSelectedItem();
		selected.setAddress(event.getNewValue().toString());
		isUpdated=Context.getInstance().currentShop().updateListOfCustomers(selected);
		if(isUpdated == true)
		{
			updateInfo.setTitle("Important message");
			updateInfo.setContentText("Details was successfully updated!");
			updateInfo.showAndWait();
		System.out.println("after update\n");

		System.out.println(Context.getInstance().currentShop().shop.show());
		}
		
	}
	public void changePhoneOfCustomer(CellEditEvent<Customer,String>  event)
	{
		Alert updateInfo=new Alert(AlertType.INFORMATION);
		boolean isUpdated;

		System.out.println("im in phonechange");
		Customer selected=customersTable.getSelectionModel().getSelectedItem();
		selected.setPhone(event.getNewValue().toString());
		isUpdated=Context.getInstance().currentShop().updateListOfCustomers(selected);
		if(isUpdated == true)
		{
			updateInfo.setTitle("Important message");
			updateInfo.setContentText("Details was successfully updated!");
			updateInfo.showAndWait();
		System.out.println("after update\n");

		System.out.println(Context.getInstance().currentShop().shop.show());
		}
	}
	
	

	
	public void addNewCustomer(ActionEvent event) throws IOException
	{
		
		Parent viewParent = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene viewScene = new Scene(viewParent);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
	    
	}
	public void addNewCart(ActionEvent event)
	{
		Alert AlertMaker=new Alert(AlertType.INFORMATION);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		 Alert.setContentText("New Cart will be added.Are you sure?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 Cart newCart=new Cart();
			 Context.getInstance().currentShop().shop.addCart(newCart); 
			 AlertMaker.setContentText("Cart was added succesfully");
				AlertMaker.showAndWait();
				for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCarts();i++)
		    	{
		    		System.out.println((Context.getInstance().currentShop().shop.getAllCarts())[i].getNumberOfCart());	
		    	}
				cartList.add(newCart);
				cartsTable.setItems(cartList);
				availableCarts.setText(String.valueOf((Context.getInstance().currentShop().shop.getAvailableCarts())));
		 }

	}
	
	public void saveCustomers(ActionEvent event) throws FileNotFoundException
	{
		Alert AlertMaker=new Alert(AlertType.INFORMATION);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert.setTitle("Saving books");
		 Alert.setContentText("List of Customers will be save in current directory.Are you sure?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 Context.getInstance().currentShop().saveInFile("customers.txt", "Customer");
			 
		AlertMaker.setHeaderText("Cool");
		AlertMaker.setContentText("List of customers succesfully saved as txt file!");
		AlertMaker.showAndWait();
		 }
	
	}
	public void saveBooks(ActionEvent event) throws FileNotFoundException
	{
		Alert AlertMaker=new Alert(AlertType.INFORMATION);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert.setTitle("Saving books");
		 Alert.setContentText("List of Books will be save in current directory.Are you sure?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 Context.getInstance().currentShop().saveInFile("books.txt", "Book");
			 
		AlertMaker.setHeaderText("Cool");
		AlertMaker.setContentText("List of books succesfully saved as txt file!");
		AlertMaker.showAndWait();
		 }
	}
	public void saveReports(ActionEvent event) throws FileNotFoundException {
		Alert AlertMaker=new Alert(AlertType.INFORMATION);
		Alert Alert=new Alert(AlertType.CONFIRMATION);
		Alert.setTitle("Saving Reports");
		 Alert.setContentText("Reports will be save in current directory.Are you sure?");
		 Optional<ButtonType> answer=Alert.showAndWait();
		 if(answer.get()==ButtonType.OK)
		 {
			 Context.getInstance().currentShop().saveInFile("reports.txt", "Report");
			 
		AlertMaker.setHeaderText("Cool");
		AlertMaker.setContentText("List of books succesfully saved as txt file!");
		AlertMaker.showAndWait();
		 }
	}

	public void initialize(URL location, ResourceBundle resources) {
		Customer[] allCustomers;
		Book[] allBooks;
		Cart[] allCarts;
		allCustomers=Context.getInstance().currentShop().shop.getCustomers();
		allBooks=Context.getInstance().currentShop().shop.getAllBooks();
		allCarts=Context.getInstance().currentShop().shop.getAllCarts();
		System.out.println("before initilization in adminController\n");
		System.out.println(Context.getInstance().currentShop().shop.show());
		for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCustomers();i++)
		{
			
			customersList.add(i, allCustomers[i]);
		}
		for(int i=0;i<Context.getInstance().currentShop().shop.getProductCount();i++)
		{
			bookList.add(i, allBooks[i]);
		}
		for(int i=0;i<Context.getInstance().currentShop().shop.getCurrentCarts();i++)
		{
			cartList.add(i, allCarts[i]);
		}
    	userName.setCellValueFactory(new PropertyValueFactory<Customer,String>("userName"));
    	pwd.setCellValueFactory(new PropertyValueFactory<Customer,String>("password"));
    	address.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
    	phone.setCellValueFactory(new PropertyValueFactory<Customer,String>("Phone"));
    	status.setCellValueFactory(new PropertyValueFactory<Customer,Boolean>("status"));
    	//personalCart.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("numOfCatalog"));
    	//editableCols();
    	customersTable.setEditable(true);
    	userName.setCellFactory(TextFieldTableCell.forTableColumn());
    	pwd.setCellFactory(TextFieldTableCell.forTableColumn());
    	address.setCellFactory(TextFieldTableCell.forTableColumn());
    	phone.setCellFactory(TextFieldTableCell.forTableColumn());
    	
    	cartNumber.setCellValueFactory(new PropertyValueFactory<Cart,Integer>("cartNumber"));
    	//cartOwner.setCellValueFactory(new PropertyValueFactory<Cart,String>("cartOwner"));
    	
    	bookName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
    	price.setCellValueFactory(new PropertyValueFactory<Book,Double>("price"));
    	sale.setCellValueFactory(new PropertyValueFactory<Book,Double>("sale"));
    	numOfCatalog.setCellValueFactory(new PropertyValueFactory<Book,Integer>("numOfCatalog"));
    	
    	sale.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    	price.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    	
    
    	
    	availableCarts.setText(String.valueOf((Context.getInstance().currentShop().shop.getAvailableCarts())));
    	busyCarts.setText(String.valueOf((Context.getInstance().currentShop().shop.getBusyCarts())));
    	onlineUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getOnlineUsers()));
    	totalUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getCurrentCustomers()));
    	offlineUsers.setText(String.valueOf(Context.getInstance().currentShop().shop.getCurrentCustomers()));
    	totalBooks.setText(String.valueOf(Context.getInstance().currentShop().shop.getProductCount()));
    	income.setText(String.valueOf(Context.getInstance().currentShop().getDailyProfit()));
    	totalSold.setText(String.valueOf(Context.getInstance().currentShop().getCountOfProductsSold()));
    	
    	
    	
    	booksTable.setEditable(true);
    	
    	customersTable.setItems(customersList);
    	booksTable.setItems(bookList);
    	cartsTable.setItems(cartList);
	}
    	
    	
}


