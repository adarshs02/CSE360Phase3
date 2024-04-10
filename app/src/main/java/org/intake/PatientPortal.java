package org.intake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PatientPortal {
	
	 public static void openPatPort() {
		 
		Stage patientStage = new Stage();
		 
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
		
		Button contactInfoButton = new Button("Contact");
		GridPane.setConstraints(contactInfoButton, 10, 2);
		patientPortalGrid.getChildren().add(contactInfoButton);
		
		Button immunButton = new Button("Immunizations");
		GridPane.setConstraints(immunButton, 10, 3);
		patientPortalGrid.getChildren().add(immunButton);
		
		Button pastMedButton = new Button("Past Medication");
		GridPane.setConstraints(pastMedButton, 10, 4);
		patientPortalGrid.getChildren().add(pastMedButton);
		
		//create scene
		Scene patientPortalUI = new Scene(patientPortalGrid, 1000, 600);
		
		//add logout button functionality
		logoutButton.setOnAction(e ->{
			LoginPage loginPage = new LoginPage();
            loginPage.start(patientStage);
		});	
		//add logout button functionality
		messagesButton.setOnAction(e ->{
			patientStage.setScene(openMessages(patientStage, patientPortalUI));
		});
		//add contact info button functionality
		contactInfoButton.setOnAction(e ->{
			patientStage.setScene(openContactInfo(patientStage, patientPortalUI));
		});
		//			//add immunizations button functionality
		immunButton.setOnAction(e ->{
			patientStage.setScene(openImmunizations(patientStage, patientPortalUI));
		});
		//			//add past medication button functionality
		pastMedButton.setOnAction(e ->{
			patientStage.setScene(openPastMed(patientStage, patientPortalUI));
		});
		
		patientStage.setScene(patientPortalUI);
		patientStage.show();
	}
	 
	 public static Scene openContactInfo(Stage mainUIstage, Scene returnScreen) {
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
				mainUIstage.setScene(returnScreen);
			});	
			
			//create scene
			Scene contactInfoUI = new Scene(coninGrid, 1000, 600);
					
			return contactInfoUI;
		}
	 
	 public static Scene openImmunizations(Stage mainUIstage, Scene returnScreen) {
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
				mainUIstage.setScene(returnScreen);
			});	
			
			//create scene
			Scene immunizaUI = new Scene(immunGrid, 1000, 600);
					
			return immunizaUI;
		}
	 
	 public static Scene openPastMed(Stage mainUIstage, Scene returnScreen) {
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
				mainUIstage.setScene(returnScreen);
			});	
			
			//create scene
			Scene pastMedUI = new Scene(pastMedGrid, 1000, 600);
					
			return pastMedUI;
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
