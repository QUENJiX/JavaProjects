package practice.p12_gui.JavaSwing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 * Demonstrates common Swing Layout Managers: BorderLayout, GridLayout, and
 * nesting panels to create complex UI structures.
 */
public class SwingLayoutsDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingLayoutsDemo().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Swing Layouts Showcase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // 1. The root pane, using BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header section (North)
        JLabel titleLabel = new JLabel("Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Display section (Center)
        JTextField displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setFont(new Font("Monospaced", Font.BOLD, 28));
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        mainPanel.add(displayField, BorderLayout.CENTER);

        // Numpad section (South) - using GridLayout
        JPanel numpadPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // 4x4 grid with 5px gaps

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.PLAIN, 18));
            numpadPanel.add(btn);
        }

        mainPanel.add(numpadPanel, BorderLayout.SOUTH);

        // Add mainPanel to frame
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
