//package application;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//public class SignUpController {
//	@FXML
//	private Label lblStatus;
//	@FXML
//	private Button Login;
//	@FXML
//	private TextField txtUserName;
//	@FXML
//	private TextField txtPassword;
//	
//	public void goToLogin(ActionEvent event) throws Exception
//	{
//		Stage primaryStage=new Stage();
//		Parent root=FXMLLoader.load(getClass().getResource("Login.fxml"));
//		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(scene);
//		primaryStage.show();
//		 ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//	}
//	
//	public void checkLogin(ActionEvent event) throws Exception
//	{
//		if(txtUserName.getText().equals("user") && txtPassword.getText().equals("pass"))
//		{
//			lblStatus.setText("Login Success");
//			Stage primaryStage=new Stage();
//			Parent root=FXMLLoader.load(getClass().getResource("Main.fxml"));
//			primaryStage.setScene(new Scene(root));
//	        primaryStage.show();
//			((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
//			
//		}
//		else
//			lblStatus.setText("Login Failed");
//			
//	}
//	
//	public void signUp(ActionEvent event) throws Exception
//	{
//		
//		Stage primaryStage=new Stage();
//		Parent root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
//		Scene scene = new Scene(root,400,400);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//		primaryStage.setScene(scene);
//		primaryStage.show();
//		 ((Stage)(((Hyperlink)event.getSource()).getScene().getWindow())).close();
//	}
//
//}
