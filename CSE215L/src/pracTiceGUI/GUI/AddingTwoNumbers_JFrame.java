package pracTiceGUI.GUI;

public class AddingTwoNumbers_JFrame {
    public static void main(String[] args) {
        // Create a JFrame
        javax.swing.JFrame frame = new javax.swing.JFrame("Adding Two Numbers");
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Create components
        javax.swing.JLabel label1 = new javax.swing.JLabel("Number 1:");
        javax.swing.JTextField textField1 = new javax.swing.JTextField(10);
        javax.swing.JLabel label2 = new javax.swing.JLabel("Number 2:");
        javax.swing.JTextField textField2 = new javax.swing.JTextField(10);
        javax.swing.JButton addButton = new javax.swing.JButton("Add");
        javax.swing.JLabel resultLabel = new javax.swing.JLabel("Result: ");

        // Set layout and add components to the frame
        frame.setLayout(new java.awt.FlowLayout());
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(addButton);
        frame.add(resultLabel);

        // Add action listener to the button
        addButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                double sum = num1 + num2;
                resultLabel.setText("Result: " + sum);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });
    }
}
