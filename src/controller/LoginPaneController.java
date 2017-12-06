package controller;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import db.DbUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPaneController implements Initializable {

	    @FXML
	    private Button LoginButton;

	    @FXML
	    private TextField UserField;

	    @FXML
	    private PasswordField PassField;

	    @FXML
	    private Label ManagerLoginLabel;

	    @FXML
	    private Label StatusLabel;

	    @FXML
	    private Button RegisterButton;

    @FXML
    private void Login() {
    	LoginButton.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    	    public void handle(ActionEvent event) {
    	        PreparedStatement ps;
    	        try {
    	            Connection connection = DbUtil.getInstance().getConnection();
    	            String sql = "SELECT username, password, status FROM userdatabase WHERE username = ? AND password = ?";
    	            ps = connection.prepareStatement(sql);
    	            ps.setString(1, UserField.getText());
    	            ps.setString(2, String.valueOf(PassField.getText()));
    	            ResultSet result = ps.executeQuery();
    	            if (result.next()) {
    	                String status = result.getString("status");
    	                if(status.equals("admin")){
    	                    StatusLabel.setText("Welcome, shop manager!");
    	                    try {
    	                        Parent parent;
    	                        parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/ManagerPane.fxml"));
    	                        Stage stage = new Stage();
    	                        stage.setTitle("ManagerPane");
    	                        stage.setScene(new Scene(parent, 450, 450));
    	                        stage.show();
    	                        ((Node)(event.getSource())).getScene().getWindow().hide();
    	                    }
    	                    catch (IOException e) {
    	                        e.printStackTrace();
    	                    }
    	                }else{
    	                    try {
    	                        Parent parent1;
    	                        StatusLabel.setText("Welcome, honored customer!");
    	                        parent1 = FXMLLoader.load(getClass().getClassLoader().getResource("view/ClientPane.fxml"));
    	                        Stage stage = new Stage();
    	                        stage.setTitle("ClientPane");
    	                        stage.setScene(new Scene(parent1, 450, 450));
    	                        stage.show();
    	                        ((Node)(event.getSource())).getScene().getWindow().hide();
    	                    } catch (Exception e) {
    	                        System.out.println("Failed to load panel");
    	                        e.printStackTrace();
    	                    }
    	                }                    
    	            }                
    	        }catch (SQLException e) {
    	            StatusLabel.setText("Wrong Password/Username, please try again");
    	        }
    		}
    	    });
    }
    @FXML
    private void goToRegister() {
        	RegisterButton.setOnAction(new EventHandler<ActionEvent>(){
        		@Override
        		public void handle(ActionEvent ev) {
        			Parent parent2;
    	            try {
    					parent2 = FXMLLoader.load(getClass().getClassLoader().getResource("view/RegisterPane.fxml"));
    					Stage stage = new Stage();
    		            stage.setTitle("RegisterPane");
    		            stage.setScene(new Scene(parent2, 450, 450));
    		            stage.show();
    		            ((Node)(ev.getSource())).getScene().getWindow().hide();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
        		}
        	});
        }


    	@Override
    	public void initialize(URL location, ResourceBundle resources) {
    		Login();
    		goToRegister();

    	}


    }
