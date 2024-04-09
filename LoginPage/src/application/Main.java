package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
        	DatabaseSetup.initializeDatabase();
            // Create the directory for the database file if it doesn't exist
            BorderPane root = new BorderPane();
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10));
            grid.setVgap(8);
            grid.setHgap(10);

            // Username Label
            Label usernameLabel = new Label("Username:");
            GridPane.setConstraints(usernameLabel, 0, 0);

            // Username Input
            TextField usernameInput = new TextField();
            usernameInput.setPromptText("Enter your username");
            GridPane.setConstraints(usernameInput, 1, 0);

            // Password Label
            Label passwordLabel = new Label("Password:");
            GridPane.setConstraints(passwordLabel, 0, 1);

            // Password Input
            PasswordField passwordInput = new PasswordField();
            passwordInput.setPromptText("Enter your password");
            GridPane.setConstraints(passwordInput, 1, 1);

            // Login Button
            Button loginButton = new Button("Login");
            GridPane.setConstraints(loginButton, 1, 2);

            // Create Account Button
            Button createAccountButton = new Button("Create Account");
            GridPane.setConstraints(createAccountButton, 1, 3);

            createAccountButton.setOnAction(event -> openCreateAccountWindow());

            loginButton.setOnAction(event -> {
                String username = usernameInput.getText().trim();
                String password = passwordInput.getText().trim();
                if (DatabaseSetup.validateLogin(username, password)) {
                    System.out.println("Login successful!");
                    // Add your logic here after successful login
                } else {
                    showAlert("Login Failed", "Invalid username or password!");
                }
            });

            grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);
            root.setCenter(grid);
            root.setBottom(createAccountButton);

            Scene scene = new Scene(root, 400, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login Page");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to open create account window
    private void openCreateAccountWindow() {
        Stage createAccountStage = new Stage();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Username Label
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        // Username Input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Enter your username");
        GridPane.setConstraints(usernameInput, 1, 0);

        // Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        // Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("Enter your password");
        GridPane.setConstraints(passwordInput, 1, 1);

        // Confirm Password Label
        Label confirmPasswordLabel = new Label("Confirm Password:");
        GridPane.setConstraints(confirmPasswordLabel, 0, 2);

        // Confirm Password Input
        PasswordField confirmPasswordInput = new PasswordField();
        confirmPasswordInput.setPromptText("Confirm your password");
        GridPane.setConstraints(confirmPasswordInput, 1, 2);

        // Create Account Button
        Button createAccountButton = new Button("Create Account");
        GridPane.setConstraints(createAccountButton, 1, 3);

        createAccountButton.setOnAction(event -> {
            String username = usernameInput.getText().trim();
            String password = passwordInput.getText().trim();
            String confirmPassword = confirmPasswordInput.getText().trim();
            if (!password.equals(confirmPassword)) {
                showAlert("Password Mismatch", "Passwords do not match. Please try again.");
            } else {
                if (DatabaseSetup.createAccount(username, password)) {
                    showAlert("Account Created", "Account created successfully.");
                    createAccountStage.close();
                } else {
                    showAlert("Error", "Failed to create account. Please try again.");
                }
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput,
                confirmPasswordLabel, confirmPasswordInput, createAccountButton);

        Scene scene = new Scene(grid, 400, 200);
        createAccountStage.setScene(scene);
        createAccountStage.setTitle("Create Account");
        createAccountStage.show();
    }
	

    // Method to show an alert dialog
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
