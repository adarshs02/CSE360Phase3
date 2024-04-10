package org.intake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DoctorPortal {
	
	public static void openDocView() {
		
		Stage doctorStage = new Stage();
		
		//create pane
		GridPane doctorGrid = new GridPane();
		doctorGrid.setPadding(new Insets(10, 10, 10, 10));
		doctorGrid.setVgap(5);
		doctorGrid.setHgap(5);
				
		//create label
		final Label ctlabel = new Label();
		GridPane.setConstraints(ctlabel, 0, 0);
		GridPane.setColumnSpan(ctlabel, 2);
		doctorGrid.getChildren().add(ctlabel);
		ctlabel.setText("Look Up Patient");
				
		//***********TEXT FIELDS*****************
		//define First name textfield
		TextField fName = new TextField();
		fName.setPrefColumnCount(10);
		fName.getText();
		GridPane.setConstraints(fName, 0, 1);
		doctorGrid.getChildren().add(fName);
		//define Last name textfield
		TextField lName = new TextField();
		lName.setPrefColumnCount(10);
		lName.getText();
		GridPane.setConstraints(lName, 0, 2);
		doctorGrid.getChildren().add(lName);
		//define DOB textfield
		TextField dob = new TextField();
		dob.setPrefColumnCount(10);
		dob.getText();
		GridPane.setConstraints(dob, 0, 3);
		doctorGrid.getChildren().add(dob);
		
		Button searchButton = new Button("Search");
		GridPane.setConstraints(searchButton, 0, 4);
		doctorGrid.getChildren().add(searchButton);
		Button messagesButton = new Button("Messages");
		GridPane.setConstraints(messagesButton, 6, 0);
		doctorGrid.getChildren().add(messagesButton);
		Button visitsButton = new Button("Visits");
		GridPane.setConstraints(visitsButton, 6, 1);
		doctorGrid.getChildren().add(visitsButton);
		Button logoutButton = new Button("Logout");
		GridPane.setConstraints(logoutButton, 6, 2);
		doctorGrid.getChildren().add(logoutButton);
		
		//create scene
		Scene doctorPortalUI = new Scene(doctorGrid, 1000, 600);
		
		//add search button functionality
		searchButton.setOnAction(e ->{
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
		});	
		//add Messages button functionality
		messagesButton.setOnAction(e ->{
			doctorStage.setScene(openMessages(doctorStage, doctorPortalUI));
		});	
		//add submit questions button functionality
		visitsButton.setOnAction(e ->{
			doctorStage.setScene(openVisits(doctorStage, doctorPortalUI));
		});
		//add logout button functionality
		logoutButton.setOnAction(e ->{
			LoginPage loginPage = new LoginPage();
            loginPage.start(doctorStage);
		});	
		
		doctorStage.setScene(doctorPortalUI);
		doctorStage.show();
	}
	
	public static Scene openVisits(Stage mainUIstage, Scene returnScreen) {
		//create pane
		GridPane visitsGrid = new GridPane();
		visitsGrid.setPadding(new Insets(10, 10, 10, 10));
		visitsGrid.setVgap(5);
		visitsGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		visitsGrid.getChildren().add(titlelabel);
		titlelabel.setText("Visits");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		visitsGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			mainUIstage.setScene(returnScreen);
		});	
		
		//create scene
		Scene visitsUI = new Scene(visitsGrid, 1000, 600);
				
		return visitsUI;
	}
	
	public static Scene openMessages(Stage mainUIstage, Scene returnScreen) {
		//create pane
		GridPane messagesGrid = new GridPane();
		messagesGrid.setPadding(new Insets(10, 10, 10, 10));
		messagesGrid.setVgap(5);
		messagesGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		messagesGrid.getChildren().add(titlelabel);
		titlelabel.setText("Messages");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		messagesGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			mainUIstage.setScene(returnScreen);
		});	
		
		//create scene
		Scene messagesUI = new Scene(messagesGrid, 1000, 600);
				
		return messagesUI;
	}

}
