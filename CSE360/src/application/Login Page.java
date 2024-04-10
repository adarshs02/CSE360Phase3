package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage {

    public void start(Stage primaryStage) {
        try {
            DatabaseSetup.initializeDatabase();
            BorderPane root = new BorderPane();
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10));
            grid.setVgap(8);
            grid.setHgap(10);

            Label usernameLabel = new Label("Username:");
            GridPane.setConstraints(usernameLabel, 0, 0);

            TextField usernameInput = new TextField();
            usernameInput.setPromptText("Enter your username");
            GridPane.setConstraints(usernameInput, 1, 0);

            Label passwordLabel = new Label("Password:");
            GridPane.setConstraints(passwordLabel, 0, 1);

            PasswordField passwordInput = new PasswordField();
            passwordInput.setPromptText("Enter your password");
            GridPane.setConstraints(passwordInput, 1, 1);

            Button loginButton = new Button("Login");
            loginButton.getStyleClass().add("standard-button");
            GridPane.setConstraints(loginButton, 1, 2);

            Button createAccountButton = new Button("Create Account");
            createAccountButton.getStyleClass().add("standard-button");
            GridPane.setConstraints(createAccountButton, 1, 3);

            createAccountButton.setOnAction(e -> openCreateAccountWindow());

            loginButton.setOnAction(event -> {
                String username = usernameInput.getText().trim();
                String password = passwordInput.getText().trim();
                DatabaseSetup.LoginResult loginResult = DatabaseSetup.validateLogin(username, password);
                if (loginResult.isSuccess()) {
                    System.out.println("Login successful!");
                    UIController.showUI(loginResult.getAccountType());
                    primaryStage.close();
                } else {
                    WindowUtil.showAlert("Login Failed", "Invalid username or password!");
                }
            });

            grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton);
            root.setCenter(grid);
            root.setBottom(createAccountButton);

            Scene scene = new Scene(root, 400, 200);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Login Page");
            primaryStage.show();
            primaryStage.getScene().getRoot().getStyleClass().add("standard-stage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

        Label accountTypeLabel = new Label("Account Type:");
        GridPane.setConstraints(accountTypeLabel, 0, 3);

        // Account Type Input (Dropdown menu)
        ComboBox<String> accountTypeInput = new ComboBox<>();
        accountTypeInput.getItems().addAll("PATIENT", "DOCTOR", "NURSE");
        accountTypeInput.setPromptText("Select account type");
        GridPane.setConstraints(accountTypeInput, 1, 3);

        // Create Account Button
        Button createAccountButton = new Button("Create Account");
        createAccountButton.getStyleClass().add("standard-button");
        GridPane.setConstraints(createAccountButton, 1, 4);
        
        createAccountButton.setOnAction(event -> {
            String username = usernameInput.getText().trim();
            String password = passwordInput.getText().trim();
            String confirmPassword = confirmPasswordInput.getText().trim();
            String accountType = accountTypeInput.getValue();
            if (!password.equals(confirmPassword)) {
            	WindowUtil.showAlert("Password Mismatch", "Passwords do not match. Please try again.");
            } else {
                if (DatabaseSetup.createAccount(username, password, accountType)) {
                	WindowUtil.showAlert("Account Created", "Account created successfully.");
                    createAccountStage.close();
                } else {
                    WindowUtil.showAlert("Error", "Failed to create account. Please try again.");
                }
            }
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput,
                confirmPasswordLabel, confirmPasswordInput, accountTypeLabel, accountTypeInput, createAccountButton);

        Scene scene = new Scene(grid, 400, 250);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        createAccountStage.setScene(scene);
        createAccountStage.setTitle("Create Account");
        createAccountStage.show();
    }
}
