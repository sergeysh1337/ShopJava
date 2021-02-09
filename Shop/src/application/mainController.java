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

private List<Product> books = new ArrayList<>();
private Image image;
private MyListener myListener;

public void goToLogin(ActionEvent event) throws Exception
{
	Stage primaryStage=new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
	Scene scene = new Scene(root,400,400);
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

private List<Product> getData() {
    List<Product> books = new ArrayList<>();
    Product book;

    book = new Product();
    book.setName("Bridgerton");
    book.setPrice(2.99);
    book.setImgSrc("/assets/images/elon-musk-15.jpg");
    book.setColor("6A7324");
    books.add(book);
//
//    book = new Product();
//    book.setName("Coconut");
//    book.setPrice(3.99);
//    book.setImgSrc("/img/coconut.png");
//    book.setColor("A7745B");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Peach");
//    book.setPrice(1.50);
//    book.setImgSrc("/img/peach.png");
//    book.setColor("F16C31");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Grapes");
//    book.setPrice(0.99);
//    book.setImgSrc("/img/grapes.png");
//    book.setColor("291D36");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Watermelon");
//    book.setPrice(4.99);
//    book.setImgSrc("/img/watermelon.png");
//    book.setColor("22371D");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Orange");
//    book.setPrice(2.99);
//    book.setImgSrc("/img/orange.png");
//    book.setColor("FB5D03");
//    books.add(book);
//
//    book = new Product();
//    book.setName("StrawBerry");
//    book.setPrice(0.99);
//    book.setImgSrc("/img/strawberry.png");
//    book.setColor("80080C");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Mango");
//    book.setPrice(0.99);
//    book.setImgSrc("/img/mango.png");
//    book.setColor("FFB605");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Cherry");
//    book.setPrice(0.99);
//    book.setImgSrc("/img/cherry.png");
//    book.setColor("5F060E");
//    books.add(book);
//
//    book = new Product();
//    book.setName("Banana");
//    book.setPrice(1.99);
//    book.setImgSrc("/img/banana.png");
//    book.setColor("E7C00F");
//    books.add(book);

    return books;
}
private void setChosenBook(Product book) {
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
            public void onClickListener(Product book) {
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