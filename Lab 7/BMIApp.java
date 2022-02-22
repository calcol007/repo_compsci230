import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BMIApp extends JFrame {
    private JTextField heightTextField, weightTextField ;
    private JButton showButton;
    private JLabel resultLabel;


    public BMIApp() {
        heightTextField = new JTextField("1", 10);
        weightTextField = new JTextField("1", 10);
        resultLabel = new JLabel("", 10);
        showButton = new JButton("Calculate BMI");
        JPanel commandpanel = new JPanel();
        commandpanel.add(new JLabel("Enter height: "));
        commandpanel.add(heightTextField);
        commandpanel.add(new JLabel("Enter weight: "));
        commandpanel.add(weightTextField);
        commandpanel.add(showButton);
        commandpanel.add(resultLabel);
        getContentPane().add(commandpanel, BorderLayout.CENTER);
        showButton.addActionListener(new ShowListener());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 150);
        setVisible(true);
    }

    public class ShowListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double height = Double.parseDouble(heightTextField.getText());
                double weight = Double.parseDouble(weightTextField.getText());
                if (height < 0 || weight < 0) {
                    throw new Exception();
                } else {
                    if (weight/(height*height) < 18.5) {
                        resultLabel.setText("You are classified as Underweight.");
                    } else if (weight/(height*height) < 25) {
                        resultLabel.setText("You are classified as Normal.");
                    } else if (weight/(height*height) < 30) {
                        resultLabel.setText("You are classified as Overweight.");
                    } else {
                        resultLabel.setText("You are classified as Obese.");
                    }
                }
            } catch (Exception exception) {
                resultLabel.setText("ERROR: Invalid. Try again.");
            }
        } 
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {new BMIApp();}
        });
    }
}