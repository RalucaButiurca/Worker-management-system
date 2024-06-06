package com.example.iss;

import HashUtil.HashUtil;
import domeniu.Boss;
import domeniu.CurrentUser;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                if (employeeService.validateEmployee(email, password)) {
                    try {
                        CurrentUser currentUser = CurrentUser.getInstance();
                        currentUser.setEmail(email);
                        String hashedPassword = HashUtil.hashPassword(password);
                        currentUser.setId(employeeService.findEmployee(email, hashedPassword).getId());
                        loadWorkerView();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorLabel.setText("Incorrect email or password for worker account.");
                    return;
                }
            } else if (isBossEmail(email)) {
                BossService bossService = serverService.getBossService();
                if (bossService.validateBoss(email, password)) {
                    try {
                        loadBossView();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    errorLabel.setText("Incorrect email or password for boss account.");
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
        errorLabel.setText("An unexpected error occurred. Please try again later.");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isWorkerEmail(String email) {
        return email.endsWith("@company.com");
    }

    private boolean isBossEmail(String email) {
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