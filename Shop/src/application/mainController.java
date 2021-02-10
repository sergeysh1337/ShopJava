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

private List<Book> books = new ArrayList<>();
private Image image;
private MyListener myListener;

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
	if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass"))
	{
		lblStatus.setText("Login Success");
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
		primaryStage.setScene(new Scene(root));
        primaryStage.show();
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		
	}
	else
		lblStatus.setText("Login Failed");		
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

private List<Book> getData() {
    List<Book> books = new ArrayList<>();
    Book book;

    book = new Book();
    book.setName("Bridgerton");
    book.setPrice(2.99);
    book.setImgSrc("/assets/images/Bridgerton.jpg");
    book.setColor("6A7324");
    books.add(book);

    book = new Book();
    book.setName("Atomic Habits");
    book.setPrice(3.99);
    book.setImgSrc("/assets/images/atomic-habits-2.jpg");
    book.setColor("A7745B");
    books.add(book);

    book = new Book();
    book.setName("Bright Light");
    book.setPrice(1.50);
    book.setImgSrc("/assets/images/bright-light-star-carrier-book-8-1.jpg");
    book.setColor("F16C31");
    books.add(book);

    book = new Book();
    book.setName("Elon Musk");
    book.setPrice(0.99);
    book.setImgSrc("/assets/images/elon-musk-15.jpg");
    book.setColor("291D36");
    books.add(book);

    book = new Book();
    book.setName("Fly into the wind");
    book.setPrice(4.99);
    book.setImgSrc("/assets/images/fly-into-the-wind.jpg");
    book.setColor("22371D");
    books.add(book);

    book = new Book();
    book.setName("Diamanti");
    book.setPrice(2.99);
    book.setImgSrc("/assets/images/i-diamanti-dei-cullingham.jpg");
    book.setColor("FB5D03");
    books.add(book);

    book = new Book();
    book.setName("I I knew then");
    book.setPrice(0.99);
    book.setImgSrc("/assets/images/if-i-knew-then-3.jpg");
    book.setColor("80080C");
    books.add(book);

    book = new Book();
    book.setName("Morning Star");
    book.setPrice(0.99);
    book.setImgSrc("/assets/images/morning-star-47.jpg");
    book.setColor("FFB605");
    books.add(book);

    book = new Book();
    book.setName("Outlander");
    book.setPrice(0.99);
    book.setImgSrc("/assets/images/outlander-16.jpg");
    book.setColor("5F060E");
    books.add(book);

    book = new Book();
    book.setName("Reckless Road");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/reckless-road-1.jpg");
    book.setColor("E7C00F");
    books.add(book);
    
    book = new Book();
    book.setName("Scorpion");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/scorpion-s-fury.jpg");
    book.setColor("c8b6ff");
    books.add(book);
    
    book = new Book();
    book.setName("Secrets of the millionaire");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/secrets-of-the-millionaire-mind-2.jpg");
    book.setColor("ffb5a7");
    books.add(book);
    
    book = new Book();
    book.setName("Shadow of night");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/shadow-of-night-2.jpg");
    book.setColor("0466c8");
    books.add(book);
    
    book = new Book();
    book.setName("Silent voices");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/silent-voices-20.jpg");
    book.setColor("cb997e");
    books.add(book);
    
    book = new Book();
    book.setName("Think again");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/think-again-18.jpg");
    book.setColor("c77dff");
    books.add(book);
    
    book = new Book();
    book.setName("The Institute");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/the-institute-14.jpg");
    book.setColor("f9844a");
    books.add(book);
    
    book = new Book();
    book.setName("This is gonna hurt");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/this-is-gonna-hurt-9.jpg");
    book.setColor("735d78");
    books.add(book);
    
    book = new Book();
    book.setName("Year of yes");
    book.setPrice(1.99);
    book.setImgSrc("/assets/images/year-of-yes-2.jpg");
    book.setColor("2ec4b6");
    books.add(book);
    


    return books;
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
	
    
    books.addAll(getData());
    if (books.size() > 0) {
        setChosenBook(books.get(0));
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
        for (int i = 0; i < books.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("itemView.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            ItemController itemController = fxmlLoader.getController();
            itemController.setData(books.get(i),myListener);

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




}