package labWorks.food;

public class Test {
    public static void main(String[] args) {
        Food pizza = new Food("Pizza", 8.99);
        Menu menu = new Menu(pizza);
        menu.showMenu();

        Food burger = new Food("Burger", 5.99);
        menu.updateMenu(burger);
        menu.showMenu();
    }
}
