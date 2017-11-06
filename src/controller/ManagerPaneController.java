package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ManagerPaneController implements Initializable{
	
	

	 

	    @FXML
	    private Button devicedbButton;

	    @FXML
	    private Button usersDBButton;

	    @FXML
	    private Button statusrepButton;

	    @FXML
	    private Button logoutButton;
	    
	    
	    private void GoToUserDB() {
	    	devicedbButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					Parent parent;
	            try {
					parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/MngDevicesPane.fxml"));
					Stage stage = new Stage();
		            stage.setTitle("MngDevicesPane");
		            stage.setScene(new Scene(parent, 450, 450));
		            stage.show();
		            ((Node)(event.getSource())).getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	});
	    }
	    
	    
	    private void GoToDeviceDB() {
	    	devicedbButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent event) {
					Parent parent;
	            try {
					parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/MngDevicesPane.fxml"));
					Stage stage = new Stage();
		            stage.setTitle("MngDevicesPane");
		            stage.setScene(new Scene(parent, 450, 450));
		            stage.show();
		            ((Node)(event.getSource())).getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	});
	    }
	    
	    private void Logout() {
	    	logoutButton.setOnAction(new EventHandler<ActionEvent>(){

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
	  GoToDeviceDB();
	  Logout();	
	  GoToUserDB();
	}

}
