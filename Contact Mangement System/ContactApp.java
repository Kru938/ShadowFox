import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ContactApp {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    
    public static void main(String[] args) {
        new ContactApp().createUI();
    }
    
    private void createUI() {
        // Create main window
        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        
        // Create components
        JList<String> contactList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(contactList);
        
        JPanel buttonPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton viewBtn = new JButton("View");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        
        // Add action listeners
        addBtn.addActionListener(e -> addContact());
        viewBtn.addActionListener(e -> viewContact(contactList));
        editBtn.addActionListener(e -> editContact(contactList));
        deleteBtn.addActionListener(e -> deleteContact(contactList));
        
        // Add components to panel
        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        
        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private void addContact() {
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField emailField = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, 
            "Add Contact", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            Contact contact = new Contact(
                nameField.getText(),
                phoneField.getText(),
                emailField.getText()
            );
            contacts.add(contact);
            listModel.addElement(contact.toString());
        }
    }
    
    private void viewContact(JList<String> contactList) {
        int index = contactList.getSelectedIndex();
        if (index >= 0) {
            Contact c = contacts.get(index);
            JOptionPane.showMessageDialog(null,
                "Name: " + c.getName() + "\n" +
                "Phone: " + c.getPhone() + "\n" +
                "Email: " + c.getEmail());
        } else {
            JOptionPane.showMessageDialog(null, 
                "Please select a contact first!");
        }
        contactList.clearSelection();
        contactList.requestFocusInWindow();
    }
    
    private void editContact(JList<String> contactList) {
        int index = contactList.getSelectedIndex();
        if (index >= 0) {
            Contact c = contacts.get(index);
            
            JTextField nameField = new JTextField(c.getName());
            JTextField phoneField = new JTextField(c.getPhone());
            JTextField emailField = new JTextField(c.getEmail());
            
            JPanel panel = new JPanel(new GridLayout(3, 2));
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Phone:"));
            panel.add(phoneField);
            panel.add(new JLabel("Email:"));
            panel.add(emailField);
            
            int result = JOptionPane.showConfirmDialog(null, panel, 
                "Edit Contact", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION) {
                c.setName(nameField.getText());
                c.setPhone(phoneField.getText());
                c.setEmail(emailField.getText());
                listModel.set(index, c.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "Please select a contact first!");
        }
    }
    
    private void deleteContact(JList<String> contactList) {
        int index = contactList.getSelectedIndex();
        if (index >= 0) {
            int confirm = JOptionPane.showConfirmDialog(null,
                "Delete this contact?", "Confirm", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                contacts.remove(index);
                listModel.remove(index);
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "Please select a contact first!");
        }
    }
}