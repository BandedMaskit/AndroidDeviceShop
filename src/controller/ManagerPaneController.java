package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	    	usersDBButton.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent gotoDB) {
					Parent parent;
	            try {
					parent = FXMLLoader.load(getClass().getClassLoader().getResource("view/MngUsersPane.fxml"));
					Stage stage = new Stage();
		            stage.setTitle("MngUsersPane");
		            stage.setScene(new Scene(parent, 450, 450));
		            stage.show();
		            ((Node)(gotoDB.getSource())).getScene().getWindow().hide();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    	});
	    }
	    private void CreateReport()  {
	    	statusrepButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent createreport) {
					
					try {
						Connection con =DbUtil.getInstance().getConnection();
					    Statement st = con.createStatement();
					    ResultSet query = st.executeQuery("SELECT 'Product Name', 'Product Type', 'Disc Capacity', 'OS', 'Processor', 'RAM', 'Price' FROM devicesmagasine");
					    Document PDFDeviceReport = new Document();
					    PdfWriter.getInstance(PDFDeviceReport, new FileOutputStream("D:\\DeviceReport.pdf"));
					    PDFDeviceReport.open();
					    PdfPTable DeviceTable = new PdfPTable(7);
                        PdfPCell cell;
                        while (query.next()) {
                        	String ProductName = query.getString("Product Name");
                        	cell = new PdfPCell(new Phrase(ProductName));
                        	DeviceTable.addCell(cell);
                        	String ProductType = query.getString("Product Type");
                        	cell = new PdfPCell(new Phrase(ProductType));
                        	DeviceTable.addCell(cell);
                        	String DiscCapacity = query.getString("Disc Capacity");
                        	cell = new PdfPCell(new Phrase(DiscCapacity));
                        	DeviceTable.addCell(cell);
                        	String OS = query.getString("OS");
                        	cell = new PdfPCell(new Phrase(OS));
                        	DeviceTable.addCell(cell);
                        	String Processor = query.getString("Processor");
                        	cell = new PdfPCell(new Phrase(Processor));
                        	DeviceTable.addCell(cell);
                        	String RAM = query.getString("RAM");
                        	cell = new PdfPCell(new Phrase(RAM));
                        	DeviceTable.addCell(cell);
                        	String Price = query.getString("Price");
                        	cell = new PdfPCell(new Phrase(Price));
                        	DeviceTable.addCell(cell);
                        	
                        }
                        PDFDeviceReport.add(DeviceTable);
                        PDFDeviceReport.close();
					}catch (SQLException e) {
                        System.out.println("Failed to load data from database");
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						System.out.println("Desired file doesn't exist");
						e.printStackTrace();
					} catch (DocumentException e) {
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
	  CreateReport();
	  GoToUserDB();
	}

}
