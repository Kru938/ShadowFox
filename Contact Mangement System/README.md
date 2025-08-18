# Contact Management System

## Overview
The **Contact Management System** is a desktop-based Java application built using **Swing** that allows users to manage their personal or professional contacts. It provides a simple graphical user interface (GUI) to **add, view, edit, and delete contacts**. This project is ideal for learning Java Swing, object-oriented programming, and basic CRUD operations.

---

## Features
- **Add Contact**: Enter a contact's name, phone number, and email.
- **View Contact**: Display details of a selected contact.
- **Edit Contact**: Modify contact details.
- **Delete Contact**: Remove contacts from the system.
- **User-Friendly GUI**: Interactive interface with buttons and list views.
- **Real-Time Updates**: Any changes to contacts are instantly reflected in the list.

---

## Workflow / How It Works
1. **Startup**:
   - The user runs the `ContactApp` class.
   - The main window opens with a **list of contacts** and four buttons: Add, View, Edit, Delete.

2. **Add a Contact**:
   - Clicking **Add** opens a popup form.
   - User enters `Name`, `Phone`, and `Email`.
   - The new contact is added to the list.

3. **View a Contact**:
   - Select a contact from the list.
   - Click **View** to see details in a popup.

4. **Edit a Contact**:
   - Select a contact and click **Edit**.
   - Modify any fields in the popup form.
   - The changes are saved and the list updates immediately.

5. **Delete a Contact**:
   - Select a contact and click **Delete**.
   - A confirmation popup appears.
   - On confirmation, the contact is removed from the list.

---

## Technologies Used
- **Java SE 8+**
- **Swing GUI Toolkit**
- **JOptionPane** for dialogs
- **ArrayList** to store contact objects
- **DefaultListModel** to manage contact display in the list

---

## Project Structure
```
ContactManagementSystem/
│
├── src/
│   ├── Contact.java       # Model class for contact details
│   └── ContactApp.java    # Main application with GUI and functionalities
│
├── README.md             # Project documentation
└── .gitignore            # Git ignore file (optional)
```

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/ContactManagementSystem.git
   ```
2. Open the project in **IDE** (e.g., Eclipse, IntelliJ, NetBeans).
3. Compile and run `ContactApp.java`.
4. Use the GUI to manage contacts.

---

## Future Enhancements
- **Persistent Storage**: Save contacts to a file or database.
- **Search Functionality**: Quickly find a contact by name or phone.
- **Enhanced GUI**: Better layout, colors, and icons.
- **Export/Import Contacts**: CSV or Excel support.

---

## Screenshots
*(Optional: Include images of your running application here)*

---

## Author
**Your Name**  
- GitHub: [yourusername](https://github.com/yourusername)  
- Email: your.email@example.com  
