package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main extends Application {
	
	private Stage primaryStage;
	private Scene mainUI, patientPortalUI, nursePortalUI, doctorPortalUI, messagesUI, contactInfoUI, immunizaUI, pastMedUI, nurseQsUI, visitsUI;
	
	
	public Scene openMessages(Scene returnScreen) {
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
			primaryStage.setScene(returnScreen);
		});	
		
		//create scene
		messagesUI = new Scene(messagesGrid, 1000, 600);
				
		return messagesUI;
	}

	public Scene openContactInfo(Scene returnScreen) {
		//create pane
		GridPane coninGrid = new GridPane();
		coninGrid.setPadding(new Insets(10, 10, 10, 10));
		coninGrid.setVgap(5);
		coninGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		coninGrid.getChildren().add(titlelabel);
		titlelabel.setText("Contact Info");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		coninGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			primaryStage.setScene(returnScreen);
		});	
		
		//create scene
		contactInfoUI = new Scene(coninGrid, 1000, 600);
				
		return contactInfoUI;
	}
	
	public Scene openImmunizations(Scene returnScreen) {
		//create pane
		GridPane immunGrid = new GridPane();
		immunGrid.setPadding(new Insets(10, 10, 10, 10));
		immunGrid.setVgap(5);
		immunGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		immunGrid.getChildren().add(titlelabel);
		titlelabel.setText("Immunizations");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		immunGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			primaryStage.setScene(returnScreen);
		});	
		
		//create scene
		immunizaUI = new Scene(immunGrid, 1000, 600);
				
		return immunizaUI;
	}
	
	public Scene openPastMed(Scene returnScreen) {
		//create pane
		GridPane pastMedGrid = new GridPane();
		pastMedGrid.setPadding(new Insets(10, 10, 10, 10));
		pastMedGrid.setVgap(5);
		pastMedGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		pastMedGrid.getChildren().add(titlelabel);
		titlelabel.setText("Past Medications");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		pastMedGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			primaryStage.setScene(returnScreen);
		});	
		
		//create scene
		pastMedUI = new Scene(pastMedGrid, 1000, 600);
				
		return pastMedUI;
	}
	
	public Scene openPatPort() {
		//create pane
		GridPane patientPortalGrid = new GridPane();
		patientPortalGrid.setPadding(new Insets(10, 10, 10, 10));
		patientPortalGrid.setVgap(5);
		patientPortalGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		patientPortalGrid.getChildren().add(titlelabel);
		titlelabel.setText("Patient Portal");
		//create history label
		final Label historylabel = new Label();
		GridPane.setConstraints(historylabel, 0, 1);
		GridPane.setColumnSpan(historylabel, 2);
		patientPortalGrid.getChildren().add(historylabel);
		historylabel.setText("PATIENT HISTORY");
		
		Button logoutButton = new Button("Logout");
		GridPane.setConstraints(logoutButton, 6, 1);
		patientPortalGrid.getChildren().add(logoutButton);
		
		Button messagesButton = new Button("Messages");
		GridPane.setConstraints(messagesButton, 10, 1);
		patientPortalGrid.getChildren().add(messagesButton);
		
		Button contactInfoButton = new Button("Contact Info");
		GridPane.setConstraints(contactInfoButton, 10, 2);
		patientPortalGrid.getChildren().add(contactInfoButton);
		
		Button immunButton = new Button("Immunizations");
		GridPane.setConstraints(immunButton, 10, 3);
		patientPortalGrid.getChildren().add(immunButton);
		
		Button pastMedButton = new Button("Past Medication");
		GridPane.setConstraints(pastMedButton, 10, 4);
		patientPortalGrid.getChildren().add(pastMedButton);
		
		//create scene
		patientPortalUI = new Scene(patientPortalGrid, 1000, 600);
		
		//add logout button functionality
		logoutButton.setOnAction(e ->{
			primaryStage.setScene(mainUI);
		});	
		//add logout button functionality
		messagesButton.setOnAction(e ->{
			primaryStage.setScene(openMessages(patientPortalUI));
		});
		//add contact info button functionality
		contactInfoButton.setOnAction(e ->{
			primaryStage.setScene(openContactInfo(patientPortalUI));
		});
		//add immunizations button functionality
		immunButton.setOnAction(e ->{
			primaryStage.setScene(openImmunizations(patientPortalUI));
		});
		//add past medication button functionality
		pastMedButton.setOnAction(e ->{
			primaryStage.setScene(openPastMed(patientPortalUI));
		});
		
		return patientPortalUI;
	}
	
	public Scene openNurseQs(Scene returnScreen) {
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
		
		//***********Text Fields*************
		//define First name textfield
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
		
		TextField presc = new TextField();
		presc.setPrefColumnCount(10);
		presc.getText();
		GridPane.setConstraints(presc, 5, 8);
		presc.setPrefHeight(150);
		presc.setPrefWidth(200);
		nurseQsGrid.getChildren().add(presc);
		
		
		TextField immuni = new TextField();
		immuni.setPrefColumnCount(10);
		immuni.getText();
		GridPane.setConstraints(immuni, 5, 9);
		immuni.setPrefHeight(150);
		immuni.setPrefWidth(200);
		nurseQsGrid.getChildren().add(immuni);
		
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
			primaryStage.setScene(returnScreen);
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
		});	
		
		//create scene
		nurseQsUI = new Scene(nurseQsGrid, 1000, 600);
				
		return nurseQsUI;
	}
	
	public Scene openNursePort() {
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
		nursePortalUI = new Scene(nurseGrid, 1000, 600);
		
		//add search button functionality
		searchButton.setOnAction(e ->{
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
		});	
		//add Messages button functionality
		messagesButton.setOnAction(e ->{
			primaryStage.setScene(openMessages(nursePortalUI));
		});	
		//add submit questions button functionality
		submitQsButton.setOnAction(e ->{
			primaryStage.setScene(openNurseQs(nursePortalUI));
		});
		//add logout button functionality
		logoutButton.setOnAction(e ->{
			primaryStage.setScene(mainUI);
		});	
		
		return nursePortalUI;
	}
	
	public Scene openVisits(Scene returnScreen) {
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
			primaryStage.setScene(returnScreen);
		});	
		
		//create scene
		visitsUI = new Scene(visitsGrid, 1000, 600);
				
		return visitsUI;
	}
	
	public Scene openDocView() {
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
		
		//create scene
		doctorPortalUI = new Scene(doctorGrid, 1000, 600);
		
		//add search button functionality
		searchButton.setOnAction(e ->{
			String firstName = fName.getText();
	        String lastName = lName.getText();
	        String dateob = dob.getText();
		});	
		//add Messages button functionality
		messagesButton.setOnAction(e ->{
			primaryStage.setScene(openMessages(doctorPortalUI));
		});	
		//add submit questions button functionality
		visitsButton.setOnAction(e ->{
			primaryStage.setScene(openVisits(doctorPortalUI));
		});
		
		
		
		return doctorPortalUI;
	}
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Main Menu");
		//create pane
		GridPane mainUIGrid = new GridPane();
		mainUIGrid.setPadding(new Insets(10, 10, 10, 10));
		mainUIGrid.setVgap(5);
		mainUIGrid.setHgap(5);
		
		//add a label
		final Label mainUIlabel = new Label();
		GridPane.setConstraints(mainUIlabel, 0, 0);
		GridPane.setColumnSpan(mainUIlabel, 2);
		mainUIGrid.getChildren().add(mainUIlabel);
		mainUIlabel.setText("NexGen");

		//add buttons
		Button patientPortalButton = new Button("Patient Portal");
		GridPane.setConstraints(patientPortalButton, 0, 2);
		mainUIGrid.getChildren().add(patientPortalButton);
		
		Button nursePortalButton = new Button("Nurse Portal");
		GridPane.setConstraints(nursePortalButton, 0, 3);
		mainUIGrid.getChildren().add(nursePortalButton);
		
		Button doctorViewButton = new Button("Doctor's View");
		GridPane.setConstraints(doctorViewButton, 0, 4);
		mainUIGrid.getChildren().add(doctorViewButton);
		
		//add patient intake button functionality
		patientPortalButton.setOnAction(e ->{
			primaryStage.setScene(openPatPort());
		});			
		//add Nurse Portal button functionality
		nursePortalButton.setOnAction(e ->{
			primaryStage.setScene(openNursePort());
		});					
		//add Patient View button functionality
		doctorViewButton.setOnAction(e ->{
			primaryStage.setScene(openDocView());
		});
		
		//create scene
		mainUI = new Scene(mainUIGrid, 1000, 600);
		
		//create window
		primaryStage.setScene(mainUI);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}