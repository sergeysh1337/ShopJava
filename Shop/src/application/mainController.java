package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class mainController implements Initializable{
@FXML
private Label lblStatus;
@FXML
private Button Login;
@FXML
private TextField txtUserName;
@FXML
private TextField txtPassword;

@FXML
private VBox chosenBookCard  = new VBox();

@FXML
private Label bookNameLable = new Label();

@FXML
private Label bookPriceLabel = new Label();

@FXML
private ImageView bookImg = new ImageView();

@FXML
private ScrollPane scroll = new ScrollPane();

@FXML
private GridPane grid = new GridPane();
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

//private List<Book> books = new ArrayList<>();
private Image image;
private MyListener myListener;

ShopManager MyShop;
Book[] books = new Book[100];
Customer[] listOfCustomers = new Customer[100];

//MyShop.shop.

public void goToLogin(ActionEvent event) throws Exception
{
	
	Stage primaryStage=new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
	Scene scene = new Scene(root);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	 ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
}
public void checkLogin(ActionEvent event) throws Exception
{
	Customer[] tempCustomers;
	tempCustomers=MyShop.shop.getCustomers();
	for(int i=0;i<MyShop.shop.getCurrentCustomers();i++)		
	{
		if(tempCustomers[i].getUserName().equals(txtUserName.getText()) 
				&& tempCustomers[i].getPassword().equals(txtPassword.getText()))
		{
			lblStatus.setText("Login Success");
			Stage primaryStage=new Stage();
			Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
			primaryStage.setScene(new Scene(root));
		    primaryStage.show();
			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
			 break;
		}
		else
			lblStatus.setText("Login failed, please try again");	
	}
}

public void goToMain() {
	
}


public void signUp(ActionEvent event) throws Exception
{
	Stage primaryStage=new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
	Scene scene = new Scene(root,400,400);
	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	 ((Stage)(((Hyperlink)event.getSource()).getScene().getWindow())).close();
}

public void createNewCustomer(ActionEvent event) throws Exception{
	Customer newCustomer;
	newCustomer= new Customer(userName.getText(), pwd.getText(), phone.getText(), address.getText());
	MyShop.shop.addCustomer(newCustomer);
	System.out.println("I'm after adding customer to array of obj\n");
	MyShop.shop.show();
	 FXMLLoader fxmlLoader = new FXMLLoader();
     fxmlLoader.setLocation(getClass().getResource("Main.fxml"));
     AnchorPane anchorPane = fxmlLoader.load();
	System.out.println("I'm after openning Main\n");
	MyShop.shop.show();
	//goToLogin(event);
}



private void setChosenBook(Book book) {
   bookNameLable.setText(book.getName());
   bookPriceLabel.setText(Main.CURRENCY + book.getPrice());
    image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
    bookImg.setImage(image);
    chosenBookCard.setStyle("-fx-background-color: #" + book.getColor() + ";\n" +
            "    -fx-background-radius: 30;");
}

@Override
public void initialize(URL location, ResourceBundle resources) {
	MyShop=new ShopManager("Book store");
	listOfCustomers = MyShop.initCustomerList();
	System.out.println("I'm after init\n");
	MyShop.shop.show();
	books=MyShop.initBooks();
    //books.addAll(getData());  List
    if (books.length > 0) {
        setChosenBook(books[0]);
        myListener = new MyListener() {
            @Override
            public void onClickListener(Book book) {
                setChosenBook(book);
            }
        };
    }

    int column = 0;
    int row = 1;
    try {
        for (int i = 0; i < MyShop.shop.getProductCount(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("itemView.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemController itemController = fxmlLoader.getController();
            itemController.setData(books[i],myListener);

            if (column == 3) {
                column = 0;
                row++;
            }

            grid.add(anchorPane, column++, row); //(child,column,row)
            //set grid width
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);

            //set grid height
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchorPane, new Insets(10));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

//public Shop bookShop = new Shop();



}