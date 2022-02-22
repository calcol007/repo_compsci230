import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ShowNameApp extends JFrame {
    private JTextField firstnameTextField, surnameTextField;
    private JLabel greetLabel;


    public ShowNameApp() {
        firstnameTextField = new JTextField("Bob", 5);
        surnameTextField = new JTextField("Hill", 5);
        greetLabel = new JLabel("NAME", 10);
        JPanel commandpanel = new JPanel();
        commandpanel.add(new JLabel("Select a firstname: "));
        commandpanel.add(firstnameTextField);
        commandpanel.add(new JLabel("Enter a surname: "));
        commandpanel.add(surnameTextField);
        commandpanel.add(greetLabel);
        getContentPane().add(commandpanel, BorderLayout.NORTH);
        firstnameTextField.addActionListener( new MyListener() );
        surnameTextField.addActionListener(new MyListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);
        setVisible(true);
    }


    public class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String firstname = firstnameTextField.getText();
            String surname = surnameTextField.getText();
            String greeting = String.format("Hello, %s %s", firstname, surname.toUpperCase());
            greetLabel.setText(greeting);
        }
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {new ShowNameApp();}
        });
    }
}
