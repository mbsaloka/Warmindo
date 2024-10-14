package controller;

import model.Inventory;

import java.util.Map;

public class InventoryController {
    private Inventory inventory;

    public InventoryController(Inventory inventory) {
        this.inventory = inventory;
    }

    public String tambahItem(String item, String jumlahStr) {
        int jumlah;

        try {
            jumlah = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            return "Input tidak valid.";
        }

        if (inventory.tambahItem(item, jumlah)) {
            return item + " ditambahkan (jumlah: " + jumlah + ")";
        } else {
            return "Item tidak valid atau jumlah tidak valid.";
        }
    }

    public String hapusItem(String item) {
        if (inventory.hapusItem(item)) {
            return item + " berhasil dihapus.";
        } else {
            return "Item " + item + " tidak ditemukan.";
        }
    }

    public String tampilkanItem() {
        return inventory.tampilkanItem();
    }

    public int getTotalItem() {
        return inventory.getTotalItem();
    }

    public Map<String, Integer> getItemMap() {
        return inventory.getItemMap();
    }

    public String kurangiItem(String item, int jumlah) {
        if (inventory.kurangiItem(item, jumlah)) {
            return item + " dikurangi sebanyak " + jumlah;
        } else {
            return "Item tidak ditemukan atau jumlah tidak valid.";
        }
    }
}
