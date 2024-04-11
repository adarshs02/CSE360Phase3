package org.intake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
		Button pendingTestButton = new Button("TEST");
		GridPane.setConstraints(pendingTestButton, 10, 10);
		doctorGrid.getChildren().add(pendingTestButton);
		//DROPDOWN OF PENDING VISITS
        ComboBox<String> pendingList = new ComboBox<>();
        pendingList.getItems().addAll("TEST");
        pendingList.setPromptText("Select Pending Visit");
        GridPane.setConstraints(pendingList, 6, 2);
        doctorGrid.getChildren().add(pendingList);
        Button openVisitButton = new Button("Open");
		GridPane.setConstraints(openVisitButton, 6, 3);
		doctorGrid.getChildren().add(openVisitButton);
		Button logoutButton = new Button("Logout");
		GridPane.setConstraints(logoutButton, 6, 5);
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
			doctorStage.setScene(MessagePage.openMessages(doctorStage, doctorPortalUI));
		});	
		
		//add pending Visit TEST button functionality
		pendingTestButton.setOnAction(e ->{
			doctorStage.setScene(openPendingVisit(doctorStage, doctorPortalUI));
		});	
		//add logout button functionality
		logoutButton.setOnAction(e ->{
			LoginPage loginPage = new LoginPage();
            loginPage.start(doctorStage);
		});	
		
		doctorStage.setScene(doctorPortalUI);
		doctorStage.show();
	}
	
	public static Scene openPendingVisit(Stage mainUIstage, Scene returnScreen) {
		//create pane
		GridPane pendingVisitGrid = new GridPane();
		pendingVisitGrid.setPadding(new Insets(10, 10, 10, 10));
		pendingVisitGrid.setVgap(5);
		pendingVisitGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 10, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		pendingVisitGrid.getChildren().add(titlelabel);
		titlelabel.setText("Patient Intake Form");
		
		final Label fnamelabel = new Label();
		GridPane.setConstraints(fnamelabel, 0, 1);
		GridPane.setColumnSpan(fnamelabel, 2);
		pendingVisitGrid.getChildren().add(fnamelabel);
		fnamelabel.setText("First Name:");
		
		final Label lnamelabel = new Label();
		GridPane.setConstraints(lnamelabel, 0, 2);
		GridPane.setColumnSpan(lnamelabel, 2);
		pendingVisitGrid.getChildren().add(lnamelabel);
		lnamelabel.setText("Last Name:");
		
		final Label doblabel = new Label();
		GridPane.setConstraints(doblabel, 0, 3);
		GridPane.setColumnSpan(doblabel, 2);
		pendingVisitGrid.getChildren().add(doblabel);
		doblabel.setText("Date of Birth:");
		
		final Label weightlabel = new Label();
		GridPane.setConstraints(weightlabel, 0, 4);
		GridPane.setColumnSpan(weightlabel, 2);
		pendingVisitGrid.getChildren().add(weightlabel);
		weightlabel.setText("Weight:");
		
		final Label heightlabel = new Label();
		GridPane.setConstraints(heightlabel, 0, 5);
		GridPane.setColumnSpan(heightlabel, 2);
		pendingVisitGrid.getChildren().add(heightlabel);
		heightlabel.setText("Height:");
		
		final Label bodytemplabel = new Label();
		GridPane.setConstraints(bodytemplabel, 0, 6);
		GridPane.setColumnSpan(bodytemplabel, 2);
		pendingVisitGrid.getChildren().add(bodytemplabel);
		bodytemplabel.setText("Body Temperature:");
		
		final Label bloodpreslabel = new Label();
		GridPane.setConstraints(bloodpreslabel, 0, 7);
		GridPane.setColumnSpan(bloodpreslabel, 2);
		pendingVisitGrid.getChildren().add(bloodpreslabel);
		bloodpreslabel.setText("Blood Pressure:");
		
		final Label presclabel = new Label();
		GridPane.setConstraints(presclabel, 0, 8);
		GridPane.setColumnSpan(presclabel, 2);
		pendingVisitGrid.getChildren().add(presclabel);
		presclabel.setText("Prescriptions:");
		
		final Label immunilabel = new Label();
		GridPane.setConstraints(immunilabel, 0, 9);
		GridPane.setColumnSpan(immunilabel, 2);
		pendingVisitGrid.getChildren().add(immunilabel);
		immunilabel.setText("Immunizations:");
		
		final Label physicalFindlabel = new Label();
		GridPane.setConstraints(physicalFindlabel, 8, 9);
		GridPane.setColumnSpan(physicalFindlabel, 2);
		pendingVisitGrid.getChildren().add(physicalFindlabel);
		physicalFindlabel.setText("Physical Findings:");
		
		//***********Text Fields*************
		//define First name textfield
		TextField fName = new TextField();
		fName.setPrefColumnCount(10);
		fName.getText();
		GridPane.setConstraints(fName, 5, 1);
		pendingVisitGrid.getChildren().add(fName);
		
		TextField lName = new TextField();
		lName.setPrefColumnCount(10);
		lName.getText();
		GridPane.setConstraints(lName, 5, 2);
		pendingVisitGrid.getChildren().add(lName);
		
		TextField dob = new TextField();
		dob.setPrefColumnCount(10);
		dob.getText();
		GridPane.setConstraints(dob, 5, 3);
		pendingVisitGrid.getChildren().add(dob);
		
		TextField weight = new TextField();
		weight.setPrefColumnCount(10);
		weight.getText();
		GridPane.setConstraints(weight, 5, 4);
		pendingVisitGrid.getChildren().add(weight);
		
		TextField height = new TextField();
		height.setPrefColumnCount(10);
		height.getText();
		GridPane.setConstraints(height, 5, 5);
		pendingVisitGrid.getChildren().add(height);
		
		TextField bodyTemp = new TextField();
		bodyTemp.setPrefColumnCount(10);
		bodyTemp.getText();
		GridPane.setConstraints(bodyTemp, 5, 6);
		pendingVisitGrid.getChildren().add(bodyTemp);
		
		TextField bloodPres = new TextField();
		bloodPres.setPrefColumnCount(10);
		bloodPres.getText();
		GridPane.setConstraints(bloodPres, 5, 7);
		pendingVisitGrid.getChildren().add(bloodPres);
		
		TextField presc = new TextField();
		presc.setPrefColumnCount(10);
		presc.getText();
		GridPane.setConstraints(presc, 5, 8);
		presc.setPrefHeight(150);
		presc.setPrefWidth(200);
		pendingVisitGrid.getChildren().add(presc);
		
		TextField immuni = new TextField();
		immuni.setPrefColumnCount(10);
		immuni.getText();
		GridPane.setConstraints(immuni, 5, 9);
		immuni.setPrefHeight(150);
		immuni.setPrefWidth(200);
		pendingVisitGrid.getChildren().add(immuni);
		
		TextField phys = new TextField();
		phys.setPrefColumnCount(10);
		phys.getText();
		GridPane.setConstraints(phys, 10, 9);
		phys.setPrefHeight(150);
		phys.setPrefWidth(200);
		pendingVisitGrid.getChildren().add(phys);
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Cancel");
		GridPane.setConstraints(returnButton, 8, 1);
		pendingVisitGrid.getChildren().add(returnButton);
		
		//Add confirm button
		Button confirmButton = new Button("Confirm");
		GridPane.setConstraints(confirmButton, 9, 1);
		pendingVisitGrid.getChildren().add(confirmButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			mainUIstage.setScene(returnScreen);
		});	
		
		//add confirm button functionality
		confirmButton.setOnAction(e ->{
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
	        String weightIn = weight.getText();
	        String heightIn = height.getText();
	        String bodyTempIn = bodyTemp.getText();
	        String bloodPresIn = bloodPres.getText();
	        String prescIn = presc.getText();
	        String immuniIn = immuni.getText();
	        String physIn = phys.getText();
		});	
		
		//create scene
		Scene pendingVisitUI = new Scene(pendingVisitGrid, 1000, 600);
				
		return pendingVisitUI;
	}
}