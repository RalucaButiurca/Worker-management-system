package com.example.iss;

import domeniu.Boss;
import domeniu.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.BossService;
import service.EmployeeService;
import service.ServerService;

import java.io.IOException;

public class SignIn {
    @FXML
    private TextField emailText;

    @FXML
    private TextField passwordText;

    @FXML
    private Label errorLabel;

    private final ServerService serverService = ServerService.getInstance();

    @FXML
    protected void onSignInButtonClick() {
        String email = emailText.getText();
        String password = passwordText.getText();

        if (isValidEmail(email)) {
            if (isWorkerEmail(email)) {
                EmployeeService employeeService = serverService.getEmployeeService();
                Employee employee = employeeService.findEmployee(email, password);
                if (employee != null && employee.getPassword().equals(password)) {
                    try {
                        loadWorkerView();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorLabel.setText("Incorrect password for worker account.");
                    return;
                }
            } else if (isBossEmail(email)) {
                BossService bossService = serverService.getBossService();
                Boss boss = bossService.findBoss(email, password);
                if (boss != null && boss.getPassword().equals(password)) {
                    try {
                        loadBossView();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorLabel.setText("Incorrect password for boss account.");
                    return;
                }
            } else {
                errorLabel.setText("Email is not registered.");
                return;
            }
        } else {
            errorLabel.setText("Invalid email format.");
            return;
        }
        // If execution reaches here, it means an unexpected error occurred
        errorLabel.setText("An unexpected error occurred. Please try again later.");
    }

    private boolean isValidEmail(String email) {
        // Add your email validation logic here
        return true;
    }

    private boolean isWorkerEmail(String email) {
        // Add your logic to check if the email belongs to a worker
        return email.endsWith("@company.com");
    }

    private boolean isBossEmail(String email) {
        // Add your logic to check if the email belongs to a boss
        return email.endsWith("@boss.com");
    }

    private void loadWorkerView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("worker-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) emailText.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    private void loadBossView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("boss-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) emailText.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
