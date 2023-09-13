# 10-dayJavaLearning-minSas

Gestion Automatisée des Livres is a Java console application designed for efficient library book management. This README provides details on setting up the environment, features, and usage instructions.

## Environment Setup

To run the application locally, follow these steps:

1. **Java:** Ensure you have Java Development Kit (JDK) installed. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Database:** Set up a MySQL or MariaDB database. Create a database and update the connection details in `Database.java`.

3. **Dependencies:** The application uses JDBC for database connectivity. Download the MySQL JDBC driver and add it to your project's classpath.

4. **Build:** Compile the Java source files using your favorite IDE or the command line.

5. **Run:** Execute the main class, `Main.java`, to start the application.

## Features

- **Book Management:**
   - Add, display, search, and modify book information.
   - Delete books from the library collection.
   
- **Borrowing and Returning:**
   - Borrow and return books, updating availability and due dates.
   - View a list of borrowed books.

- **Statistical Reports:**
   - Generate reports on available books, borrowed books, and lost books.
   - Analyze library trends and optimize the collection.

## Usage

1. Launch the application by running `Main.java`.
2. Navigate through the menu options using numeric input.
3. Follow on-screen instructions for various tasks, such as adding books, borrowing, returning, and generating reports.
4. Ensure proper setup of the database for accurate functionality.
