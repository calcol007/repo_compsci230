import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

class AnimalTreeDemo extends JFrame {
	JTextField messageTextField;
	JTree tree;
	DefaultTreeModel treeModel;
	DefaultMutableTreeNode root;

    public AnimalTreeDemo() {
        root = new DefaultMutableTreeNode("Animals");
        root.add(new DefaultMutableTreeNode("cat"));
        root.add(new DefaultMutableTreeNode("dog"));
        root.add(new DefaultMutableTreeNode("bird"));
        root.add(new DefaultMutableTreeNode("lion"));
        root.add(new DefaultMutableTreeNode("tiger"));
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

        tree.addTreeSelectionListener(new MySelectionListener());
        messageTextField = new JTextField("Hello, xxx", 20);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(messageTextField);
        getContentPane().add(buttonsPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tree), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    public class MySelectionListener implements TreeSelectionListener {
        public void valueChanged(TreeSelectionEvent e) {
            Object node = tree.getLastSelectedPathComponent();
            if (node == null) {
                messageTextField.setText("No selection!");
            } else {
                messageTextField.setText(String.format("Hello, %s", node));
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { new AnimalTreeDemo(); }
        });
    }

}