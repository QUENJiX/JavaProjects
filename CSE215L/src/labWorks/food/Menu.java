package labWorks.food;

public class Menu {
    Food foodItem;

    Menu(Food foodItem) {
        this.foodItem = foodItem;
    }

    public void updateMenu(Food newFood) {
        foodItem = newFood;
    }

    public void showMenu() {
        System.out.println("Menu Item:");
        foodItem.displayInfo();
    }
}
