import model.Inventory;
import controller.InventoryController;
import view.InventoryView;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        InventoryController controller = new InventoryController(inventory);
        InventoryView view = new InventoryView(controller);
        view.setVisible(true);
    }
}
