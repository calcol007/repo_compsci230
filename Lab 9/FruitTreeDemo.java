import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

class FruitTreeDemo extends JFrame {
	JTextField nameTextField, indexTextField;
	JButton addButton, removeButton;
	JTree tree;
	DefaultTreeModel treeModel;
	DefaultMutableTreeNode root;

    public FruitTreeDemo() {
        root = new DefaultMutableTreeNode("Fruit");
        root.add(new DefaultMutableTreeNode("apple"));
        root.add(new DefaultMutableTreeNode("orange"));
        root.add(new DefaultMutableTreeNode("banana"));
        root.add(new DefaultMutableTreeNode("kiwifruit"));
        root.add(new DefaultMutableTreeNode("grapefruit"));
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

        nameTextField = new JTextField("watermelon", 10);
        indexTextField = new JTextField("1", 5);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        addButton.addActionListener(new AddListener());
        removeButton.addActionListener(new RemoveListener());
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(new JLabel("Enter:"));
        buttonsPanel.add(nameTextField);
        buttonsPanel.add(addButton);
        buttonsPanel.add(new JLabel("Remove by index:"));
        buttonsPanel.add(indexTextField);
        buttonsPanel.add(removeButton);
        getContentPane().add(buttonsPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(tree), BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setVisible(true);
    }

    public class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = nameTextField.getText();
            int childCount = root.getChildCount();
            DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(text);
            treeModel.insertNodeInto(newChild, root, childCount);
        }
    }

    public class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = Integer.valueOf(indexTextField.getText());
            if (index >= 0 && index < root.getChildCount()) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)treeModel.getChild(root, index);
                treeModel.removeNodeFromParent(node);
            }
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { new FruitTreeDemo(); }
        });
    }
}