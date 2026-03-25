package labWorks.animaltask;

public class Elephant extends Animal {
    private boolean isAwake;

    public Elephant(String name, int age, boolean isAwake) {
        super(name, age);
        this.isAwake = isAwake;
    }

    @Override
    public void makeSound() {
        if (isAwake) {
            System.out.println("The elephant trumpets loudly!");
        } else {
            System.out.println("Animal is sleeping.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Awake: " + isAwake);
        System.out.println("Species: Elephant");
    }

    public void sprayWater() {
        if (isAwake) {
            System.out.println("Uses its trunk to spray a massive splash of water!");
        } else {
            System.out.println("Animal is sleeping.");
        }
    }
}
