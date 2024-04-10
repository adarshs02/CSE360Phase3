package application;

import javafx.scene.control.Alert;

public class WindowUtil {
	static void showAlert(String title, String message) {
   	 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
   }
}
