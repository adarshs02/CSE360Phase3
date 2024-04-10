//package org.intake;
//
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.stage.Stage;
//import javafx.scene.layout.GridPane;
//
//
//public class OpenMainUI {
//	private static Stage mainUIstage;
//	private static Scene mainUI;
//	
//	public static void MainUIStart() {
//		mainUIstage = new Stage();
//		mainUIstage.setTitle("Main Menu");
//		//create pane
//		GridPane mainUIGrid = new GridPane();
//		mainUIGrid.setPadding(new Insets(10, 10, 10, 10));
//		mainUIGrid.setVgap(5);
//		mainUIGrid.setHgap(5);
//		
//		//create scene
//		mainUI = new Scene(mainUIGrid, 1000, 600);
//		
//		//add a label
//		final Label mainUIlabel = new Label();
//		GridPane.setConstraints(mainUIlabel, 0, 0);
//		GridPane.setColumnSpan(mainUIlabel, 2);
//		mainUIGrid.getChildren().add(mainUIlabel);
//		mainUIlabel.setText("NexGen");
//
//		//add buttons
//		Button patientPortalButton = new Button("Patient Portal");
//		GridPane.setConstraints(patientPortalButton, 0, 2);
//		mainUIGrid.getChildren().add(patientPortalButton);
//		
//		Button nursePortalButton = new Button("Nurse Portal");
//		GridPane.setConstraints(nursePortalButton, 0, 3);
//		mainUIGrid.getChildren().add(nursePortalButton);
//		
//		Button doctorViewButton = new Button("Doctor's View");
//		GridPane.setConstraints(doctorViewButton, 0, 4);
//		mainUIGrid.getChildren().add(doctorViewButton);
//		
//		//add patient portal button functionality
//		patientPortalButton.setOnAction(e ->{
//			mainUIstage.setScene(PatientPortal.openPatPort(mainUIstage, mainUI));
//		});			
//		//add Nurse Portal button functionality
//		nursePortalButton.setOnAction(e ->{
//			mainUIstage.setScene(NursePortal.openNursePort(mainUIstage, mainUI));
//		});					
//		//add Doctor View button functionality
//		doctorViewButton.setOnAction(e ->{
//			mainUIstage.setScene(DoctorPortal.openDocView(mainUIstage, mainUI));
//		});
//		
//		
//		//create window
//		mainUIstage.setScene(mainUI);
//		mainUIstage.show();
//	}
//}
