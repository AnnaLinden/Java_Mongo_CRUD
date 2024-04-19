package com.example.java_mongo_crud;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.bson.Document;

public class View extends Application {
    private Controller controller;

    private TextField idTextField = new TextField();
    private TextField nameTextField = new TextField();
    private TextField ageTextField = new TextField();
    private TextField cityTextField = new TextField();

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // Method to display alerts
    public void display(AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to show data in text fields when a document is read
    public void showData(Document document) {
        // Directly using text fields since they are class variables now
        nameTextField.setText(document.getString("name"));
        ageTextField.setText(document.getString("age"));
        cityTextField.setText(document.getString("city"));
    }

    public void start(Stage stage) {
        // Initialize the controller
        MongoDBConnectionManager dbManager = MongoDBConnectionManager.getInstance(); // Ensure singleton instance is created.
        PersonDAO personDAO = new PersonDAO(); // Assuming this does not depend on any other settings.
        this.controller = new Controller(personDAO, this); // Set the controller with this view instance.

        // Now setup the UI components
        setupUI(stage);
    }

    private void setupUI(Stage stage) {
        Label idLabel = new Label("ID:");
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label cityLabel = new Label("City:");

        idTextField = new TextField();
        nameTextField = new TextField();
        ageTextField = new TextField();
        cityTextField = new TextField();

        Button addButton = new Button("Add");
        Button readButton = new Button("Read");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10); // Vertical gap between nodes

        gridPane.add(idLabel, 0, 0);
        gridPane.add(idTextField, 1, 0);
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameTextField, 1, 1);
        gridPane.add(ageLabel, 0, 2);
        gridPane.add(ageTextField, 1, 2);
        gridPane.add(cityLabel, 0, 3);
        gridPane.add(cityTextField, 1, 3);

        gridPane.add(addButton, 0, 4);
        gridPane.add(readButton, 1, 4);
        gridPane.add(updateButton, 0, 5);
        gridPane.add(deleteButton, 1, 5);

        // Set button actions now that controller is guaranteed to be non-null
        addButton.setOnAction(e -> controller.addDocument(idTextField.getText(), nameTextField.getText(), ageTextField.getText(), cityTextField.getText()));
        readButton.setOnAction(e -> controller.readDocument(idTextField.getText()));
        updateButton.setOnAction(e -> controller.updateDocument(idTextField.getText(), nameTextField.getText(), ageTextField.getText(), cityTextField.getText()));
        deleteButton.setOnAction(e -> controller.deleteDocument(idTextField.getText()));

        Scene scene = new Scene(gridPane, 400, 250);
        stage.setScene(scene);
        stage.setTitle("MongoDB CRUD Operations");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

