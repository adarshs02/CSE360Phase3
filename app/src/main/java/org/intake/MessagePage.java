package org.intake;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		
		//create scene
		Scene messagesUI = new Scene(messagesGrid, 1000, 600);
				
		return messagesUI;
	}

}
