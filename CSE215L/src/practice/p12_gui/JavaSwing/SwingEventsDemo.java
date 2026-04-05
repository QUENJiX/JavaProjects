package practice.p12_gui.JavaSwing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Demonstrates common Swing Event Handling mechanisms, including
 * ActionListeners, MouseListeners (hover effects/clicks), and KeyListeners.
 */
public class SwingEventsDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingEventsDemo().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Swing Events Playground");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 1. ActionListener (Button Click)
        JButton actionButton = new JButton("Click Me!");
        actionButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Action Performed: " + e.getActionCommand());
        });

        // 2. MouseListener (Hover / Click inside panel area)
        JPanel mousePanel = new JPanel();
        mousePanel.setBackground(Color.LIGHT_GRAY);
        JLabel mouseStatusLabel = new JLabel("Hover over or click this area");
        mousePanel.add(mouseStatusLabel);

        mousePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mousePanel.setBackground(Color.CYAN);
                mouseStatusLabel.setText("Mouse Entered!");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mousePanel.setBackground(Color.LIGHT_GRAY);
                mouseStatusLabel.setText("Hover over or click this area");
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                mouseStatusLabel.setText(String.format("Clicked at X:%d, Y:%d", e.getX(), e.getY()));
            }
        });

        // 3. KeyListener (Typing into a text field)
        JTextField keyField = new JTextField();
        JLabel keyStatusLabel = new JLabel("Start typing above...");

        keyField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                keyStatusLabel.setText("Last key typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // E.g. Check for specific keys like Enter or Escape
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    keyStatusLabel.setText("ENTER was pressed!");
                }
            }
        });

        // Assemble GUI
        panel.add(actionButton);
        panel.add(mousePanel);
        panel.add(keyField);
        panel.add(keyStatusLabel);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
