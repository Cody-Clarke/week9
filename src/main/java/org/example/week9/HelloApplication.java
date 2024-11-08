package org.example.week9;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Button addBtn;
    private Label firstName;
    private Label lastName;
    private Label email;
    private Label dateOfBirth;
    private Label zipCode;
    private Label lblMsg;
    private String msg;
    private TextField firstName_tv, lastName_tv, email_tv, dateOfBirth_tv, zipCode_tv;




//    private BooleanProperty isFirstNameTv;
//    private BooleanProperty isLastNameTv;
//    private BooleanProperty isEmailTv;
//    private BooleanProperty isDateOfBirthTv;
//    private BooleanProperty isZipCodeTv;



     //Regular Expressions for Validation
    final String firstName_regex = "[A-Za-z]{2,25}";
    final String lastName_regex = "[A-Za-z]{2,25}";
    final String email_regex = "(\\w+)@(Farmingdale).(edu)";
    final String dateOfBirth_Regex = "(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])-(\\d{4})";
    final String zipCode_regex = "\\d{5}";

    public boolean checkFirstName() {
        String name = firstName_tv.getText();
        boolean isValid = name.matches(firstName_regex);
        if (!isValid) {
            msg +=  "Invalid first name\n";
        }
        return isValid;
    }
    public boolean checkLastName() {
        String lastName = lastName_tv.getText();
        boolean isValid = lastName.matches(lastName_regex);
        if (!isValid) {
            msg +=  "Invalid last name\n";
        }
        return isValid;
    }
    public boolean checkEmail() {
        String email = email_tv.getText();
        boolean isValid = email.matches(email_regex);
        if (!isValid) {
            msg +=  "Invalid email\n";
        }
        return isValid;
    }
    public boolean checkDateOfBirth() {
        String dateOfBirth = dateOfBirth_tv.getText();
        boolean isValid = dateOfBirth.matches(dateOfBirth_Regex);
        if (!isValid) {
            msg +=  "Invalid date of birth\n";
        }
        return isValid;
    }
    public boolean checkZipCode() {
        String zipCode = zipCode_tv.getText();
        boolean isValid = zipCode.matches(zipCode_regex);
        if (!isValid) {
            msg +=  "Invalid zip code\n";
        }
        return isValid;
    }

    @Override
    public void start(Stage primaryStage) {

        // Create labels and text fields
        firstName = new Label("First Name");
        lastName = new Label("Last Name");
        email = new Label("Email");
        dateOfBirth = new Label("Date of Birth (MM/DD/YYYY)");
        zipCode = new Label("Zip Code");

        firstName_tv = new TextField();
        firstName_tv.setMinWidth(300);
        lastName_tv = new TextField();
        lastName_tv.setMinWidth(300);
        email_tv = new TextField();
        email_tv.setMinWidth(300);
        dateOfBirth_tv = new TextField();
        dateOfBirth_tv.setMinWidth(300);
        zipCode_tv = new TextField();
        zipCode_tv.setMinWidth(300);

        // Create the "Add" button
        addBtn = new Button("Add");

        firstName_tv.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                msg = "";
                checkFirstName();
                lblMsg.setText(msg);
            }
        });

        lastName_tv.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                msg = "";
                checkFirstName();
                checkLastName();
                lblMsg.setText(msg);
            }
        });

        email_tv.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                msg = "";
                checkFirstName();
                checkLastName();
                checkEmail();
                lblMsg.setText(msg);
            }
        });
        dateOfBirth_tv.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                msg = "";
                checkFirstName();
                checkLastName();
                checkEmail();
                checkDateOfBirth();
                lblMsg.setText(msg);
            }
        });
        zipCode_tv.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                msg = "";
                checkFirstName();
                checkLastName();
                checkEmail();
                checkDateOfBirth();
                checkZipCode();
                lblMsg.setText(msg);
            }
        });

        lblMsg = new Label();










        // Handle the "Add" button click
        addBtn.setOnAction(event -> {handleAddButtonClick();});

        // Layout the form in a GridPane
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.setHgap(12);
        grid.add(firstName, 0, 0);
        grid.add(firstName_tv, 1, 0);
        grid.add(lastName, 0, 1);
        grid.add(lastName_tv, 1, 1);
        grid.add(email, 0, 2);
        grid.add(email_tv, 1, 2);
        grid.add(dateOfBirth, 0, 3);
        grid.add(dateOfBirth_tv, 1, 3);
        grid.add(zipCode, 0, 4);
        grid.add(zipCode_tv, 1, 4);
        grid.add(addBtn, 1, 5);
        grid.add(lblMsg, 1, 7);

        // Set the scene
        Scene scene = new Scene(grid, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration Form");
        primaryStage.show();

    }

    private void handleAddButtonClick() {
        msg="";
        checkFirstName();
        checkLastName();
        checkEmail();
        checkDateOfBirth();
        checkZipCode();
        lblMsg.setText(msg);
        if(checkFirstName() && checkLastName() &&checkEmail() && checkDateOfBirth() && checkZipCode()) {

        }

    }

    public static void main(String[] args) {
        launch();
    }
}