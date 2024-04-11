package org.intake;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

public class NursePortal {

	public static void openNursePort() {
		
		Stage nurseStage = new Stage();
		
		//create pane
		GridPane nurseGrid = new GridPane();
		nurseGrid.setPadding(new Insets(10, 10, 10, 10));
		nurseGrid.setVgap(5);
		nurseGrid.setHgap(5);
		
		//create label
		final Label ctlabel = new Label();
		GridPane.setConstraints(ctlabel, 0, 0);
		GridPane.setColumnSpan(ctlabel, 2);
		nurseGrid.getChildren().add(ctlabel);
		ctlabel.setText("Look Up Patient");
		
		//***********TEXT FIELDS*****************
		//define First name textfield
		TextField fName = new TextField();
		fName.setPrefColumnCount(10);
		fName.getText();
		GridPane.setConstraints(fName, 0, 1);
		nurseGrid.getChildren().add(fName);
		//define Last name textfield
		TextField lName = new TextField();
		lName.setPrefColumnCount(10);
		lName.getText();
		GridPane.setConstraints(lName, 0, 2);
		nurseGrid.getChildren().add(lName);
		//define DOB textfield
		TextField dob = new TextField();
		dob.setPrefColumnCount(10);
		dob.getText();
		GridPane.setConstraints(dob, 0, 3);
		nurseGrid.getChildren().add(dob);
		
		Button searchButton = new Button("Search");
		GridPane.setConstraints(searchButton, 0, 4);
		nurseGrid.getChildren().add(searchButton);
		Button messagesButton = new Button("Messages");
		GridPane.setConstraints(messagesButton, 6, 0);
		nurseGrid.getChildren().add(messagesButton);
		Button submitQsButton = new Button("Patient Intake");
		GridPane.setConstraints(submitQsButton, 6, 1);
		nurseGrid.getChildren().add(submitQsButton);
		Button logoutButton = new Button("Logout");
		GridPane.setConstraints(logoutButton, 6, 2);
		nurseGrid.getChildren().add(logoutButton);
		
		//create scene
		Scene nursePortalUI = new Scene(nurseGrid, 1000, 600);
		
		//add search button functionality
		searchButton.setOnAction(e ->{
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
		});	
		//add Messages button functionality
		messagesButton.setOnAction(e ->{
			nurseStage.setScene(MessagePage.openMessages(nurseStage, nursePortalUI));
		});	
//		//add submit questions button functionality
		submitQsButton.setOnAction(e ->{
			nurseStage.setScene(openNurseQs(nurseStage, nursePortalUI));
		});
//		//add logout button functionality
		logoutButton.setOnAction(e ->{
	            LoginPage loginPage = new LoginPage();
	            loginPage.start(nurseStage);
		});	
		
		nurseStage.setScene(nursePortalUI);
		nurseStage.show();
    }
	
	public static Scene openNurseQs(Stage mainUIstage, Scene returnScreen) {
		//create pane
		GridPane nurseQsGrid = new GridPane();
		nurseQsGrid.setPadding(new Insets(10, 10, 10, 10));
		nurseQsGrid.setVgap(5);
		nurseQsGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 10, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		nurseQsGrid.getChildren().add(titlelabel);
		titlelabel.setText("Patient Intake Form");
		
		final Label patientIDLabel = new Label();
		GridPane.setConstraints(patientIDLabel, 0, 0);
		GridPane.setColumnSpan(patientIDLabel, 2);
		nurseQsGrid.getChildren().add(patientIDLabel);
		patientIDLabel.setText("UserID:");
		
		final Label fnamelabel = new Label();
		GridPane.setConstraints(fnamelabel, 0, 1);
		GridPane.setColumnSpan(fnamelabel, 2);
		nurseQsGrid.getChildren().add(fnamelabel);
		fnamelabel.setText("First Name:");
		
		final Label lnamelabel = new Label();
		GridPane.setConstraints(lnamelabel, 0, 2);
		GridPane.setColumnSpan(lnamelabel, 2);
		nurseQsGrid.getChildren().add(lnamelabel);
		lnamelabel.setText("Last Name:");
		
		final Label doblabel = new Label();
		GridPane.setConstraints(doblabel, 0, 3);
		GridPane.setColumnSpan(doblabel, 2);
		nurseQsGrid.getChildren().add(doblabel);
		doblabel.setText("Date of Birth:");
		
		final Label weightlabel = new Label();
		GridPane.setConstraints(weightlabel, 0, 4);
		GridPane.setColumnSpan(weightlabel, 2);
		nurseQsGrid.getChildren().add(weightlabel);
		weightlabel.setText("Weight:");
		
		final Label heightlabel = new Label();
		GridPane.setConstraints(heightlabel, 0, 5);
		GridPane.setColumnSpan(heightlabel, 2);
		nurseQsGrid.getChildren().add(heightlabel);
		heightlabel.setText("Height:");
		
		final Label bodytemplabel = new Label();
		GridPane.setConstraints(bodytemplabel, 0, 6);
		GridPane.setColumnSpan(bodytemplabel, 2);
		nurseQsGrid.getChildren().add(bodytemplabel);
		bodytemplabel.setText("Body Temperature:");
		
		final Label bloodpreslabel = new Label();
		GridPane.setConstraints(bloodpreslabel, 0, 7);
		GridPane.setColumnSpan(bloodpreslabel, 2);
		nurseQsGrid.getChildren().add(bloodpreslabel);
		bloodpreslabel.setText("Blood Pressure:");
		
		final Label presclabel = new Label();
		GridPane.setConstraints(presclabel, 0, 8);
		GridPane.setColumnSpan(presclabel, 2);
		nurseQsGrid.getChildren().add(presclabel);
		presclabel.setText("Prescriptions:");
		
		final Label immunilabel = new Label();
		GridPane.setConstraints(immunilabel, 0, 9);
		GridPane.setColumnSpan(immunilabel, 2);
		nurseQsGrid.getChildren().add(immunilabel);
		immunilabel.setText("Immunizations:");

		final Label sendToLabel = new Label();
		GridPane.setConstraints(sendToLabel, 0, 10);
		GridPane.setColumnSpan(sendToLabel, 2);
		nurseQsGrid.getChildren().add(sendToLabel);
		sendToLabel.setText("Select Doctor to Send to:");
		
		//***********Text Fields*************
		//define First name textfield
		TextField patientID = new TextField();
		patientID.setPrefColumnCount(10);
		patientID.getText();
		GridPane.setConstraints(patientID, 5, 0);
		nurseQsGrid.getChildren().add(patientID);
		
		TextField fName = new TextField();
		fName.setPrefColumnCount(10);
		fName.getText();
		GridPane.setConstraints(fName, 5, 1);
		nurseQsGrid.getChildren().add(fName);
		
		TextField lName = new TextField();
		lName.setPrefColumnCount(10);
		lName.getText();
		GridPane.setConstraints(lName, 5, 2);
		nurseQsGrid.getChildren().add(lName);
		
		TextField dob = new TextField();
		dob.setPrefColumnCount(10);
		dob.getText();
		GridPane.setConstraints(dob, 5, 3);
		nurseQsGrid.getChildren().add(dob);
		
		TextField weight = new TextField();
		weight.setPrefColumnCount(10);
		weight.getText();
		GridPane.setConstraints(weight, 5, 4);
		nurseQsGrid.getChildren().add(weight);
		
		TextField height = new TextField();
		height.setPrefColumnCount(10);
		height.getText();
		GridPane.setConstraints(height, 5, 5);
		nurseQsGrid.getChildren().add(height);
		
		TextField bodyTemp = new TextField();
		bodyTemp.setPrefColumnCount(10);
		bodyTemp.getText();
		GridPane.setConstraints(bodyTemp, 5, 6);
		nurseQsGrid.getChildren().add(bodyTemp);
		
		TextField bloodPres = new TextField();
		bloodPres.setPrefColumnCount(10);
		bloodPres.getText();
		GridPane.setConstraints(bloodPres, 5, 7);
		nurseQsGrid.getChildren().add(bloodPres);
		
		TextArea presc = new TextArea();
		presc.setPrefColumnCount(10); 
		presc.setPrefHeight(150); 
		presc.setWrapText(true);
		presc.getText();
		GridPane.setConstraints(presc, 5, 8);
		nurseQsGrid.getChildren().add(presc);
		
		TextArea immuni = new TextArea();
		immuni.setPrefColumnCount(10); 
		immuni.setPrefHeight(150); 
		immuni.setWrapText(true); 
		immuni.getText();
		GridPane.setConstraints(immuni, 5, 9);
		nurseQsGrid.getChildren().add(immuni);
		
		ComboBox<String> docList = new ComboBox<>();
		List<User> doctorsList = DatabaseSetup.getDoctors();
		List<String> doctorsListStrings = new ArrayList<>();
		
		for (User doctor : doctorsList) {
		    // Access or manipulate your doctor object here
		    String str = (doctor.getUsername() + " | " + doctor.getFullName()); // Example: print the doctor's information
		    doctorsListStrings.add(str);
		}
		
		docList.getItems().addAll(doctorsListStrings);
		docList.setPromptText("Select Doctor");
        GridPane.setConstraints(docList, 5, 10);
        nurseQsGrid.getChildren().add(docList);
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Cancel");
		GridPane.setConstraints(returnButton, 8, 1);
		nurseQsGrid.getChildren().add(returnButton);
		
		//Add confirm button
		Button confirmButton = new Button("Confirm");
		GridPane.setConstraints(confirmButton, 9, 1);
		nurseQsGrid.getChildren().add(confirmButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			mainUIstage.setScene(returnScreen);
		});	
		
		//add confirm button functionality
		confirmButton.setOnAction(e ->{
			String patientIDIn = patientID.getText();
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
	        String weightIn = weight.getText();
	        String heightIn = height.getText();
	        String bodyTempIn = bodyTemp.getText();
	        String bloodPresIn = bloodPres.getText();
	        String prescIn = presc.getText();
	        String immuniIn = immuni.getText();
	        String docIn = docList.getValue();
	        String docUserId = docIn.split(" \\| ")[0];
	        //GRAB DOCTOR INFO
	        VisitFormDatabase pendingVisitsDB = new VisitFormDatabase("PendingVisits");
	        
	        HashMap<String, String> visitForm = new HashMap<String, String>();
	        visitForm.put("patientID", patientIDIn);
			visitForm.put("firstName", firstName);
			visitForm.put("lastName", lastName);
			visitForm.put("dateob", dateob);
			visitForm.put("weight", weightIn);
			visitForm.put("height", heightIn);
			visitForm.put("bodyTemp", bodyTempIn);
			visitForm.put("bloodPres", bloodPresIn);
			visitForm.put("presc", prescIn);
			visitForm.put("immuni", immuniIn);
			visitForm.put("phys", "");

			try {
				pendingVisitsDB.updateFileData(docUserId, patientIDIn, visitForm);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});	
		
		//create scene
		Scene nurseQsUI = new Scene(nurseQsGrid, 1000, 600);
				
		return nurseQsUI;
	}
	
}
