package labWorks.animaltask;

public class AnimalTest {
    public static void main(String[] args) {
        Animal randomAnimal = new Animal("Generic Animal", 0);
        Giraffe giraffe = new Giraffe("Gerald", 8, false);
        Elephant elephant = new Elephant("Dumbo", 15, true);

        System.out.println("---Animal Information---");
        randomAnimal.displayInfo();
        System.out.println("");
        giraffe.displayInfo();
        System.out.println();
        elephant.displayInfo();

        System.out.println("---Animal Sounds---");
        randomAnimal.makeSound();
        giraffe.makeSound();
        elephant.makeSound();
    }
}
