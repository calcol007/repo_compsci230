import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.swing.table.*;

public class EnglishFrenchDemo extends JFrame  {
  JTable table;
  public EnglishFrenchDemo() {
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("English");
    tableModel.addColumn("French");
    tableModel.insertRow(0, new Object[] { "tooth", "dent"});
    tableModel.insertRow(0, new Object[] { "yellow", "jaune" });
    tableModel.insertRow(0, new Object[] { "horse", "cheval" });
    tableModel.insertRow(0, new Object[] { "tree", "arbre" });
    tableModel.insertRow(0, new Object[] { "apple", "pomme" });
    tableModel.insertRow(0, new Object[] { "house", "maison" });
    
    
    
    
    
    table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 200);
    setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() { new EnglishFrenchDemo(); }
    });
  }
}