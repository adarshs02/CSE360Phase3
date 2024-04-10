package org.intake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MessagePage {
	
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
		
		//CREATE DROPDOWN TO HOLD ALL MESSAGES
		// Account Type Input (Dropdown menu)
		
        ComboBox<String> messageList = new ComboBox<>();
        messageList.getItems().addAll("TEST");
        messageList.setPromptText("Select Message to Open");
        GridPane.setConstraints(messageList, 2, 1);
        messagesGrid.getChildren().add(messageList);
		//CREATE BUTTON TO OPEN MESSAGE
		Button openButton = new Button("Open Message");
		GridPane.setConstraints(openButton, 6, 3);
		messagesGrid.getChildren().add(openButton);
		//add open button functionality
		openButton.setOnAction(e ->{
			//OPEN MESSAGE
		});	

		//create scene
		
		Scene messagesUI = new Scene(messagesGrid, 1000, 600);
		Button createButton = new Button("New Message");
		GridPane.setConstraints(createButton, 6, 2);
		messagesGrid.getChildren().add(createButton);
		
		TextField fromBox = new TextField();
		fromBox.setPrefColumnCount(10);
		fromBox.getText();
		GridPane.setConstraints(fromBox, 2, 2);
		messagesGrid.getChildren().add(fromBox);
		
		TextField subjectBox = new TextField();
		subjectBox.setPrefColumnCount(10);
		subjectBox.getText();
		GridPane.setConstraints(subjectBox, 2, 3);
		messagesGrid.getChildren().add(subjectBox);
		
		TextField messageBox = new TextField();
		messageBox.setPrefColumnCount(10);
		messageBox.getText();
		GridPane.setConstraints(messageBox, 2, 4);
		messageBox.setPrefHeight(150);
		messageBox.setPrefWidth(200);
		messagesGrid.getChildren().add(messageBox);
		
		//add create button functionality
		createButton.setOnAction(e ->{
			mainUIstage.setScene(openCreateMessage(mainUIstage, messagesUI));
		});	
				
		return messagesUI;
	}
	
	public static Scene openCreateMessage(Stage mainUIstage, Scene returnScreen) {
		//create pane
		GridPane createMessageGrid = new GridPane();
		createMessageGrid.setPadding(new Insets(10, 10, 10, 10));
		createMessageGrid.setVgap(5);
		createMessageGrid.setHgap(5);
		
		//***********Labels*****************
		//create title label
		final Label titlelabel = new Label();
		GridPane.setConstraints(titlelabel, 6, 0);
		GridPane.setColumnSpan(titlelabel, 2);
		createMessageGrid.getChildren().add(titlelabel);
		titlelabel.setText("Create Message");
		
		//***********Buttons******************
		//Add back button
		Button returnButton = new Button("Back");
		GridPane.setConstraints(returnButton, 6, 1);
		createMessageGrid.getChildren().add(returnButton);
		
		//add back button functionality
		returnButton.setOnAction(e ->{
			mainUIstage.setScene(returnScreen);
		});	
		
		//CREATE TEXTBOX FOR RECIPIENT
		//CREATE TEXTBOX FOR SUBJECT
		//CREATE TEXTBOX FOR MESSAGE
		TextField sendToBox = new TextField();
		sendToBox.setPrefColumnCount(10);
		sendToBox.getText();
		GridPane.setConstraints(sendToBox, 2, 1);
		createMessageGrid.getChildren().add(sendToBox);
		
		TextField subjectBox = new TextField();
		subjectBox.setPrefColumnCount(10);
		subjectBox.getText();
		GridPane.setConstraints(subjectBox, 2, 3);
		createMessageGrid.getChildren().add(subjectBox);
		
		TextField messageBox = new TextField();
		messageBox.setPrefColumnCount(10);
		messageBox.getText();
		GridPane.setConstraints(messageBox, 2, 4);
		messageBox.setPrefHeight(150);
		messageBox.setPrefWidth(200);
		createMessageGrid.getChildren().add(messageBox);
		//CREATE SEND BUTTON
		Button sendButton = new Button("Send");
		GridPane.setConstraints(sendButton, 3, 5);
		createMessageGrid.getChildren().add(sendButton);
		
		//add back button functionality
		sendButton.setOnAction(e ->{
			String sendToString = sendToBox.getText();
	        String subjectString = subjectBox.getText();
	        String messageString = messageBox.getText();
	        
		});
		//create scene
		Scene createMessageUI = new Scene(createMessageGrid, 1000, 600);
				
		return createMessageUI;
	}

}
