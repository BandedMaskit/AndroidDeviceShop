package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MngUsersPaneController implements Initializable {

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> statusColumn;

    @FXML
    private TableColumn<User, String> usernameColumn;

    @FXML
    private TableColumn<User, String> firstNameColumn;

    @FXML
    private TableColumn<User, String> secondNameColumn;

    @FXML
    private TableColumn<User, String> adressColumn;

    @FXML
    private TableColumn<User, String> paymentColumn;

    @FXML
    private TableColumn<User, String> itemsColumn;

    @FXML
    private Button admninrightsButton;

    @FXML
    private Button backButton;
    

    private void BackToManagerPane() {
    	backButton.setOnAction(new EventHandler<ActionEvent>() {
    			@Override
    			public void handle(ActionEvent ev) {
    				Parent parent;
    		try {
                    parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/ManagerPane.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("ManagerPane");
                    stage.setScene(new Scene(parent, 450, 450));
                    stage.show();
                    ((Node)(ev.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
    		
    	}

    	});
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BackToManagerPane();
		
	}
	
    	}
    