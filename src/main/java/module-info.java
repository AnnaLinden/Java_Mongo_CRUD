module com.example.java_mongo_crud {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.java_mongo_crud to javafx.fxml;
    exports com.example.java_mongo_crud;
}