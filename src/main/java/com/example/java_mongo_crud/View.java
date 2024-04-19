package com.example.java_mongo_crud;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
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

    public void display(AlertType alertType, String message) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void showData(Document document) {
        // Directly using text fields since they are class variables now
        nameTextField.setText(document.getString("name"));
        ageTextField.setText(document.getString("age"));
        cityTextField.setText(document.getString("city"));
    }

    public void start(Stage stage) {
        MongoDBConnectionManager dbManager = MongoDBConnectionManager.getInstance();
        PersonDAO personDAO = new PersonDAO();
        this.controller = new Controller(personDAO, this);
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
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

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


        addButton.setOnAction(e -> controller.addDocument(idTextField.getText(), nameTextField.getText(), ageTextField.getText(), cityTextField.getText()));
        readButton.setOnAction(e -> controller.readDocument(idTextField.getText()));
        updateButton.setOnAction(e -> controller.updateDocument(idTextField.getText(), nameTextField.getText(), ageTextField.getText(), cityTextField.getText()));
        deleteButton.setOnAction(e -> controller.deleteDocument(idTextField.getText()));

        // Apply Bootstrap classes to text fields
        idTextField.getStyleClass().add("form-control");
        nameTextField.getStyleClass().add("form-control");
        ageTextField.getStyleClass().add("form-control");
        cityTextField.getStyleClass().add("form-control");

        // Apply Bootstrap button classes to buttons
        addButton.getStyleClass().add("btn");
        addButton.getStyleClass().add("btn-primary");
        readButton.getStyleClass().add("btn");
        readButton.getStyleClass().add("btn-primary");
        updateButton.getStyleClass().add("btn");
        updateButton.getStyleClass().add("btn-primary");
        deleteButton.getStyleClass().add("btn");
        deleteButton.getStyleClass().add("btn-danger");

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        gridPane.getColumnConstraints().addAll(col1, col2);

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

