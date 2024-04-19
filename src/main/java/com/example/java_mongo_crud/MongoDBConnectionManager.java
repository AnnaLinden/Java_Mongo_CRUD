package com.example.java_mongo_crud;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.ConnectionString;


//MongoDBConnectionManager is a singleton.
// It manages the MongoDB connection and ensures there's only one instance throughout the application.
public class MongoDBConnectionManager {
    private static MongoDBConnectionManager instance;
    private MongoClient mongoClient;
    private MongoDatabase database;

    private MongoDBConnectionManager() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("CRUD_person");
    }

    public static MongoDBConnectionManager getInstance() {
        if (instance == null) {
            instance = new MongoDBConnectionManager();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
