package labWorks.animaltask;

public class Giraffe extends Animal {
    private boolean isAwake;

    public Giraffe(String name, int age, boolean isAwake) {
        super(name, age);
        this.isAwake = isAwake;
    }

    @Override
    public void makeSound() {
        if (isAwake) {
            System.out.println(name + " makes a low-frequency hum...!");
        } else {
            System.out.println("Animal is sleeping.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Awake: " + isAwake);
        System.out.println("Species: Giraffe");
    }

    public void reachHighLeaves() {
        if (isAwake) {
            System.out.println("Stretches its long neck to eat leaves from the canopy!");
        } else {
            System.out.println("Animal is sleeping.");
        }
    }
}
