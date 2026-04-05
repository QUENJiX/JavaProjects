package practice.p12_gui.JavaSwing;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Demonstrates the absolute basics of Java Swing.
 * Shows how to create a window (JFrame), add a content pane (JPanel),
 * and add basic components (JButton, JLabel, JTextField).
 */
public class SwingBasicsDemo {

    public static void main(String[] args) {
        // Swing GUI operations should be executed on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        // 1. Create the main window
        JFrame frame = new JFrame("Swing Basics Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center on screen

        // 2. Create a panel to hold components (using default FlowLayout)
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // 3. Create components
        JLabel welcomeLabel = new JLabel("Welcome to Java Swing!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField nameField = new JTextField(15);

        JButton submitButton = new JButton("Submit");

        // Add action listener to the button
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Hello, " + name + "!", "Greeting",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 4. Add components to the panel
        mainPanel.add(welcomeLabel);
        mainPanel.add(new JLabel("Enter Name:"));
        mainPanel.add(nameField);
        mainPanel.add(submitButton);

        // 5. Add panel to the frame and make it visible
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
