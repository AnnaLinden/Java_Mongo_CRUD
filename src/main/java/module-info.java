module com.example.java_mongo_crud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    opens com.example.java_mongo_crud to javafx.fxml;
    exports com.example.java_mongo_crud;
}