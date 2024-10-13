import model.Inventory;
import controller.InventoryController;
import view.InventoryView;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        InventoryController controller = new InventoryController(inventory);
        InventoryView view = new InventoryView(controller);
        view.setVisible(true);

        inventory.tambahItem("Indomie Goreng", 10);
        inventory.tambahItem("Indomie Soto", 5);
        inventory.tambahItem("Indomie Ayam Bawang", 3);
        inventory.hapusItem("Indomie Soto");
        inventory.tampilkanItem();
    }
}
