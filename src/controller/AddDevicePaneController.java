package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import db.DbUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDevicePaneController implements Initializable{

    @FXML
    private Button addDeviceButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField typeField;

    @FXML
    private TextField memoryField;

    @FXML
    private TextField systemField;

    @FXML
    private TextField processorField;

    @FXML
    private TextField ramField;

    @FXML
    private TextField priceField;

    
    private void BackToDevicePane() {
    	backButton.setOnAction(new EventHandler<ActionEvent>(){

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
    private void AddDevice() {
   	 addDeviceButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ev2) {
   	        try {
   	        	Connection con = DbUtil.getInstance().getConnection();
   	        	String SQLAdd = "INSERT INTO `devicesmagasine` (`Product Name`, `Product Type`, `Disc Capacity`, `OS`, `Processor`, `RAM`, `Price`)" 
   	        	+ "VALUES ('"+nameField.getText()+"','"+typeField.getText()+"','"+Integer.valueOf(memoryField.getText().toString())+"','"+systemField.getText()+"'"
   	        			+ ",'"+processorField.getText()+"','"+Integer.valueOf(ramField.getText().toString())+"','"+Double.valueOf(priceField.getText().toString())+"')";
   	        	    con.prepareStatement(SQLAdd);
   	        		PreparedStatement ps = con.prepareStatement(SQLAdd);
   	        		ps.executeUpdate(SQLAdd);
   	        	
   	        }
   	        catch (SQLException e) {
   	        	System.out.println("Incorrect data input, please check your data and try again");
   	        	e.printStackTrace();
   	        }
				
			}
   		 
   	 });
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BackToDevicePane();
		AddDevice();
	}

}