package com.example.java_mongo_crud;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

//PersonDAO: This class handles CRUD operations for the "Person" entity.
public class PersonDAO {
    private final MongoCollection<Document> collection;

    public PersonDAO() {
        MongoDatabase database = MongoDBConnectionManager.getInstance().getDatabase();
        collection = database.getCollection("person");
    }

    public void addPerson(String id, String name, String age, String city) {
        Document person = new Document("_id", id)
                .append("name", name)
                .append("age", age)
                .append("city", city);
        collection.insertOne(person);
    }

    public Document getPerson(String id) {
        return collection.find(new Document("_id", id)).first();
    }

    public void updatePerson(String id, String name, String age, String city) {
        Document update = new Document("$set", new Document("name", name)
                .append("age", age)
                .append("city", city));
        collection.updateOne(new Document("_id", id), update);
    }

    public void deletePerson(String id) {
        collection.deleteOne(new Document("_id", id));
    }
}
