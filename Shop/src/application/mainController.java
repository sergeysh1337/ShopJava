package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class mainController {
@FXML
private Label lblStatus;
@FXML
private Label helloLabel;
@FXML
private Button Login;
@FXML
private TextField txtUserName;
@FXML
private TextField txtPassword;
@FXML

public void goToLogin(ActionEvent event) throws Exception
{
	
	Stage primaryStage=new Stage();
	Parent root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
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
		Parent root=FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		
		primaryStage.show();
		((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
		
	}
	else
		lblStatus.setText("Login Failed");
		
}


}