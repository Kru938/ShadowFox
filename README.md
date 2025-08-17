"# Library-Management-System" 
# Library Management System

A Java-based library management system with SQLite database persistence.

## Features
- User registration and login
- Book management (add/list)
- Book borrowing and returning
- Simple recommendations system

## Requirements
- Java JDK 17+
- SQLite JDBC driver (included)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   ```
2. Navigate to project directory:
   ```bash
   cd library-management-system
   ```

## Running the Application
Windows:
```bash
run.bat
```

Manual compilation and execution:
```bash
javac -cp lib/sqlite-jdbc-3.50.3.0.jar -d bin src/Main.java src/models/*.java src/services/*.java src/utils/*.java
java --enable-native-access=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED -cp bin;lib/sqlite-jdbc-3.50.3.0.jar Main
```

## Project Structure
- `src/`: Contains all Java source files
- `lib/`: Contains the SQLite JDBC driver
- `bin/`: Compiled class files (auto-generated)
- `library.db`: SQLite database (auto-generated)

## License
MIT License