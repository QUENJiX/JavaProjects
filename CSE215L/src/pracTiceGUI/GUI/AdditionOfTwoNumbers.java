package pracTiceGUI.GUI;

import javax.swing.JOptionPane;

public class AdditionOfTwoNumbers {
    public static void main(String[] args) {
        String num1 = JOptionPane.showInputDialog("Enter the first number:");
        String num2 = JOptionPane.showInputDialog("Enter the second number:");
        double number1 = Double.parseDouble(num1);
        double number2 = Double.parseDouble(num2);
        double sum = number1 + number2;
        JOptionPane.showMessageDialog(null, "The sum of " + number1 + " and " + number2 + " is: " + sum);
        System.exit(0);
    }
}
