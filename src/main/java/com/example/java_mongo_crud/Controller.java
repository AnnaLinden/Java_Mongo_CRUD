package com.example.java_mongo_crud;

import javafx.scene.control.Alert.AlertType;
import org.bson.Document;

public class Controller {
    private final PersonDAO personDAO;
    private final View view;

    public Controller(PersonDAO personDAO, View view) {
        this.personDAO = personDAO;
        this.view = view;
        view.setController(this);
    }

    public void addDocument(String id, String name, String age, String city) {
        personDAO.addPerson(id, name, age, city);
        view.display(AlertType.INFORMATION, "Document added successfully.");
    }

    public void readDocument(String id) {
        Document document = personDAO.getPerson(id);
        if (document != null) {
            view.showData(document);
        } else {
            view.display(AlertType.ERROR, "Document not found.");
        }
    }

    public void updateDocument(String id, String name, String age, String city) {
        personDAO.updatePerson(id, name, age, city);
        view.display(AlertType.INFORMATION, "Document updated successfully.");
    }

    public void deleteDocument(String id) {
        personDAO.deletePerson(id);
        view.display(AlertType.INFORMATION, "Document deleted successfully.");
    }

}



