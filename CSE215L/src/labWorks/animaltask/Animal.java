package labWorks.animaltask;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Generic animal sound!");
    }

    public void adoptAnimal() {
        System.out.println(name + " has been adopted at age " + age);
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
