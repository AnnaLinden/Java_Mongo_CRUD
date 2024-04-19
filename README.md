# MongoDB CRUD Operations in Java

## Overview
This Java application demonstrates basic CRUD (Create, Read, Update, Delete) operations using MongoDB as the database. It allows users to interact with a MongoDB database through a graphical user interface (GUI) built with JavaFX.

## Features
- Add a new person to the database.
- Read existing person details from the database.
- Update existing person details in the database.
- Delete a person record from the database.

## Prerequisites
- Java Development Kit (JDK)
- MongoDB installed and running locally

## How to Run
1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Ensure that MongoDB is running locally on the default port (27017).
4. Run the `Main` class to start the application.


## Architecture Overview
- **Controller Class**: The Controller class serves as the intermediary between the UI (View) and the database operations (PersonDAO). It effectively delegates responsibilities and ensures separation of concerns.
- **MongoDB Connection**: The MongoDBConnectionManager class manages the MongoDB connection and ensures that there's only one instance throughout the application. It follows the singleton pattern, which is appropriate for managing resources like database connections.
- **PersonDAO Class**: The PersonDAO class encapsulates CRUD operations for the "Person" entity. It interacts with the MongoDB database using the Java MongoDB driver. The methods are appropriately named (addPerson, getPerson, updatePerson, deletePerson) and follow standard CRUD conventions.
- **View Class**: The View class represents the user interface (UI) of the application. It uses JavaFX for building the UI components. The UI layout is organized using a GridPane, which is suitable for arranging components in rows and columns.
- **Styling**: Bootstrap classes are applied to the text fields and buttons to improve the UI appearance. This enhances the overall user experience and makes the application visually appealing.
## Screenshots
![Screenshot1](screenshots/screenshot1.png)
![Screenshot2](screenshots/screenshot2.png)
![Screenshot3](screenshots/screenshot3.png)

## Credits
- This project was created by Anna Linden.

