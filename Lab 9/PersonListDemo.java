import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

class Person {
    private String name;
    public Person(String n) {
        this.name = n;
    }
    public String getName() {return name; }
    public String toString() { return name; }
}

public class PersonListModel<Person> extends AbstractListModel<Person> {
    
    private ArrayList<Person> people;
    
    public PersonListModel() {
        people = new ArrayList<Person>();
    }
    
    public int getSize() {
        return people.size();
    }
    
    public Person getElementAt(int index) {
        return people.get(index);
    }
    
    public void addElement(Person element) {
        people.add(element);
        int index = people.size();
        fireIntervalAdded(element, index, index);
    }
    
    public void removeElementAt(int index) {
        people.remove(index);
        fireIntervalRemoved(this, index, index);
    }
    
}

public class PersonListDemo extends JFrame {
    JList<Person> people;
    PersonListModel<Person> listModel;
    JButton addButton, removeButton;
    JTextField nameTextField;

    public PersonListDemo() {
        listModel = new PersonListModel<Person>();
        Person[] array = new Person[]{new Person("Mary"), new Person("John"), new Person("Alan"), new Person("Michael")};
        for (Person p: array) listModel.addElement(p);
        people = new JList<Person>(listModel);
        nameTextField = new JTextField("Name");
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        addButton.addActionListener(new AddListener());
        removeButton.addActionListener(new RemoveListener());

        JPanel input_panel = new JPanel();
        input_panel.add(new JLabel("Enter:"));
        input_panel.add(nameTextField);
        input_panel.add(addButton);
        input_panel.add(removeButton);
        getContentPane().add(input_panel, BorderLayout.SOUTH);
        getContentPane().add(new JScrollPane(people), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }
  
    public class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameTextField.getText();
            Person newPerson = new Person(name);
            listModel.addElement(newPerson);
        }
    }

    public class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = people.getSelectedIndex();
            if (index > -1) {
                listModel.removeElementAt(index);
            }
        }
    }
  
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { new PersonListDemo(); }
        });
    }
}