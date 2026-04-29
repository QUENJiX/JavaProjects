package CSE215L_Quiz_2;

public class Main {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("Galaxy A14", 250, "Samsung");
        Smartphone s2 = new Smartphone("iPhone SE", 500, "Apple");
        
        s1.applyStudentDiscount(.1);
        s2.applyStudentDiscount(.15);

        s1.calculateWarrantyFee();
        s2.calculateWarrantyFee();

        s1.calculateFinalPrice();
        s2.calculateFinalPrice();

        System.out.println();
        s1.displaySpecs();
        s2.displaySpecs();

        System.out.println();
        s1.printInvoice();
        s2.printInvoice();
    }
}
