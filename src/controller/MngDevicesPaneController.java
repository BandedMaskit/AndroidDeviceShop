package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import data.Device;
import db.DbUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MngDevicesPaneController implements Initializable{

	    @FXML
	    private TableView<Device> DeviceTable;

	    @FXML
	    private TableColumn<Device, Integer> IDColumn;

	    @FXML
	    private TableColumn<Device, String> nameColumn;

	    @FXML
	    private TableColumn<Device, String> typeColumn;

	    @FXML
	    private TableColumn<Device, Integer> capacityColumn;

	    @FXML
	    private TableColumn<Device, String> systemColumn;

	    @FXML
	    private TableColumn<Device, String> processorColumn;

	    @FXML
	    private TableColumn<Device, Integer> RAMColumn;

	    @FXML
	    private TableColumn<Device, Double> priceColumn;

	    @FXML
	    private ScrollBar deviceScrollBar;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button backButton;
	    
	    private ObservableList<Device> data;
    
    private void BackToManagerPane() {
    	backButton.setOnAction(new EventHandler<ActionEvent>() {
    			@Override
    			public void handle(ActionEvent ev) {
    				Parent parent;
    		try {
                    parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/ManagerPane.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("ManagerPane");
                    stage.setScene(new Scene(parent));
                    stage.show();
                    ((Node)(ev.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
    		
    	}
});
    
}  	
     
     public void buildData() {
    	 data = FXCollections.observableArrayList();
    	 try {
    		 Connection con = DbUtil.getInstance().getConnection();
    		 String sql = "Select * from devicesmagasine";
    		 ResultSet rs = con.createStatement().executeQuery(sql);
    		 while(rs.next()) {
    			 data.add(new Device(rs.getInt(1), rs.getString(2),  rs.getString(3), rs.getInt(4), rs.getString(5),  rs.getString(6), rs.getInt(7), rs.getDouble(8)));
    		 }
    	 } catch (SQLException ex){
    		 ex.printStackTrace();	 
    	 }
    	 
    	 IDColumn.setCellValueFactory(new PropertyValueFactory<Device, Integer>("deviceid"));
 		nameColumn.setCellValueFactory(new PropertyValueFactory<Device, String>("productname"));
 		typeColumn.setCellValueFactory(new PropertyValueFactory<Device, String>("producttype"));
 		capacityColumn.setCellValueFactory(new PropertyValueFactory<Device, Integer>("memorycapacity"));
 		systemColumn.setCellValueFactory(new PropertyValueFactory<Device, String>("os"));
 		processorColumn.setCellValueFactory(new PropertyValueFactory<Device, String>("processor"));
 		RAMColumn.setCellValueFactory(new PropertyValueFactory<Device, Integer>("ram"));
 		priceColumn.setCellValueFactory(new PropertyValueFactory<Device, Double>("price"));
 		
 		DeviceTable.setItems(null);
		DeviceTable.setItems(data);
     }
     
     private void deleteDevice() {
    	 deleteButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ev1)  {
			    try {
			    	Connection con = DbUtil.getInstance().getConnection();
			    	String SQLDelete = "DELETE FROM devicesmagasine WHERE deviceid =?";
			    	Device selectedDevice = DeviceTable.getSelectionModel().getSelectedItem();
			    	if (selectedDevice != null) {
			    		PreparedStatement ps = con.prepareStatement(SQLDelete);
			    		ps.setInt(1, selectedDevice.getDeviceid());
			    		ps.executeUpdate();
			    	    DeviceTable.getItems().remove(selectedDevice);
			    		
			    	}
			    	
			    } catch (Exception ex1){
			    	ex1.printStackTrace();
			    }
				
			}
    		 
    	 });
     }
     
     private void addDevice() {
    	 addButton.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ev2) {
				Parent parent;
    	        try {
    	        	 parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/AddDevicePane.fxml"));
    	        	 Stage stage = new Stage();
    	        	 stage.setTitle("AddDevicePane");
    	        	 stage.setScene(new Scene(parent));
    	        	 stage.show();
    	        	((Node)(ev2.getSource())).getScene().getWindow().hide();
    	        }
    	        catch (Exception e) {
    	        	e.printStackTrace();
    	        }
				
    	 }
    		 
    	 });
     }
		
		
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buildData();
		BackToManagerPane();
	    deleteDevice();
		addDevice();
		
	}




	

}
