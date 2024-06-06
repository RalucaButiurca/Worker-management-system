package com.example.iss;

import domeniu.Boss;
import domeniu.CurrentUser;
import domeniu.Employee;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.BossService;
import service.EmployeeService;
import service.ServerService;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstWorker {

    @FXML
    private TextField signintimeText;
    @FXML
    private Label errorLabel;
    private final ServerService serverService = ServerService.getInstance();

    @FXML
    protected void onPresentButtonClick() {
        String signintime = signintimeText.getText();

        if (isValidTimeString(signintime)) {
            EmployeeService employeeService = serverService.getEmployeeService();
            Employee employee = employeeService.addSignintime(signintime, CurrentUser.getInstance().getId());
            if (employee != null && employee.getSignintime() != null) {
                try {
                    loadWorker2View();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            errorLabel.setText("Incorrect time.");
            return;
        }
        return;
    }

    private boolean isValidTimeString(String str) {
        // Regular expression to match the time format HH:mm
        String regex = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    private void loadWorker2View() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("worker2-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) signintimeText.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}

