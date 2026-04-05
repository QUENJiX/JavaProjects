package practice.p12_gui.JavaSwing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * Demonstrates more advanced Swing components: JTable (with standard model),
 * JTabbedPane (tabs), JMenuBar (menus), and JScrollPane.
 */
public class SwingAdvancedDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAdvancedDemo().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Advanced Swing Components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);

        // 1. Setup Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Swing Advanced Demo version 1.0"));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        // 2. Setup Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // 3. Tab 1: Form / Options
        JPanel optionsPanel = new JPanel();
        optionsPanel.add(new JLabel("A Checkbox: "));
        optionsPanel.add(new JCheckBox("Enable feature X"));
        optionsPanel.add(new JLabel("A ComboBox: "));
        String[] colors = { "Red", "Green", "Blue", "Yellow" };
        optionsPanel.add(new JComboBox<>(colors));

        tabbedPane.addTab("Options", optionsPanel);

        // 4. Tab 2: Table
        // Set up tabular data using DefaultTableModel for mutability
        String[] columns = { "ID", "Name", "Department", "Performance Rating" };
        Object[][] data = {
                { 1, "Alice Smith", "HR", 4.5 },
                { 2, "Bob Johnson", "Engineering", 4.8 },
                { 3, "Charlie Davis", "Marketing", 3.9 },
                { 4, "Dana White", "Sales", 4.2 }
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        table.setFillsViewportHeight(true); // Table occupies entire scroll pane

        JButton addRowButton = new JButton("Add Record");
        addRowButton.addActionListener(e -> {
            model.addRow(new Object[] { model.getRowCount() + 1, "New Employee", "TBD", 0.0 });
        });

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER); // Always wrap JTable in JScrollPane
        tablePanel.add(addRowButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Employee Table", tablePanel);

        frame.add(tabbedPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
