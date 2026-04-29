package CSE215L_Quiz_2;

public class Smartphone extends Device implements Warranty, DiscountEligble {
    private String brand;

    public Smartphone(String modelName, double basePrice, String brand){
        super(modelName, basePrice);
        this.brand = brand;
    }

    public String getBrand() { return this.brand; }
    public void setBrand(String brand) { this.brand = brand; }

    @Override
    public double calculateWarrantyFee(){
        return .05*getBasePrice();
    }


    public double applyStudentDiscount(double rate){
        return getBasePrice()*rate;
    }

    @Override
    public double calculateFinalPrice(){
        if(getModelName().equalsIgnoreCase("Samsung")){
            return (getBasePrice() - applyStudentDiscount(.1)) + calculateWarrantyFee();
        }else{
            return (getBasePrice() - applyStudentDiscount(.15)) + calculateWarrantyFee();
        }
    }
    @Override
    public void displaySpecs(){
        System.out.println("Model: " + getModelName());
        System.out.println("Price: " + getBasePrice());
    }

    public void printInvoice(){
        System.out.println("Brand: " + this.getBrand());
        System.out.println("Model: " + getModelName());
        System.out.println("Base Price: " + getBasePrice());
        if (getModelName().equalsIgnoreCase("Samsung")) {
            System.out.println("Discount: " + applyStudentDiscount(.1));
        } else {
            System.out.println("Discount: " + applyStudentDiscount(.15));
        }
        System.out.println("Warranty: " + calculateWarrantyFee());
        System.out.println("Final Price: " + calculateFinalPrice());
    }

}
