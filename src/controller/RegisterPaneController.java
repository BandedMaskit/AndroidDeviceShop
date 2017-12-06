package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import data.User.PrefferedPayment;
import db.DbUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;


public class RegisterPaneController implements Initializable{


	    @FXML
	    private TextField userField;

	    @FXML
	    private TextField firstNameField;

	    @FXML
	    private TextField lastNameField;

	    @FXML
	    private TextField adressField;

	    @FXML
	    private ChoiceBox<PrefferedPayment> paymentMethodBox;

	    @FXML
	    private Button registerButton;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private PasswordField passwordField;

	    private void Register() {
	    	registerButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event)  {
					 PreparedStatement ps;
		    	        try {
		    	            Connection con = DbUtil.getInstance().getConnection();
		    	            String registerQuery = "INSERT INTO `userdatabase`(status, username, password, firstname, lastname, shippingadress, prefferedpayment) "
		    	            		+ "VALUE ('user','"+userField.getText()+"','"+passwordField.getText()+"','"+firstNameField.getText()+"','"+lastNameField.getText()+"','"+adressField.getText()+"','"+paymentMethodBox.getValue()+"')";
		    	            ps = con.prepareStatement(registerQuery); 
		    	            ps.executeUpdate(registerQuery);
		    	        }
		    	        catch (Exception e) {
		    	        	System.out.println("Invalid data imput, please check your data and try again");
		    	        	e.printStackTrace();
		    	        }
				}

	    	});
	    	}
	    private void Cancel() {
	    	cancelButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					Parent parent;
	            try {
					parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/LoginPane.fxml"));
					Stage stage = new Stage();
		            stage.setTitle("LoginPane");
		            stage.setScene(new Scene(parent, 450, 450));
		            stage.show();
		            ((Node)(event.getSource())).getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	});
}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Cancel();
		Register();

	}

}
