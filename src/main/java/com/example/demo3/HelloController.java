package com.example.demo3;

import com.example.demo3.connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {
    public TextField login;
    public TextField pass;
    public CheckBox check;
    public TextField passText;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onClick(ActionEvent actionEvent) throws SQLException, IOException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM USERS WHERE username = '" + login.getText() + "' AND password = '" + pass.getText() + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                kek();
            } else {
                pass.setText("");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void kek() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("reg-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Register1!");
        stage.setScene(scene);
        stage.show();
        Stage thisStage = (Stage) login.getScene().getWindow();
        thisStage.close();
    }

    public void onCheck(ActionEvent actionEvent) {
        if (check.isSelected()) {
            passText.setText(pass.getText());
            passText.setVisible(true);
            pass.setVisible(false);
            return;
        }
        pass.setText(passText.getText());
        pass.setVisible(true);
        passText.setVisible(false);
    }
}