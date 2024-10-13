package model;

import java.util.HashMap;
import java.util.Map;

public class Inventory implements Storable {
    private Map<String, Integer> itemMap;
    private int totalItem;

    public Inventory() {
        itemMap = new HashMap<>();
        totalItem = 0;
    }

    @Override
    public boolean tambahItem(String item, int jumlah) {
        if (item.isEmpty() || item == null || jumlah <= 0) {
            return false;
        }
        itemMap.put(item, itemMap.getOrDefault(item, 0) + jumlah);
        totalItem += jumlah;
        return true;
    }

    @Override
    public boolean hapusItem(String item) {
        if (itemMap.containsKey(item)) {
            totalItem -= itemMap.get(item);
            itemMap.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public String tampilkanItem() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : itemMap.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString().isEmpty() ? "Item tidak ditemukan." : sb.toString();
    }

    public boolean kurangiItem(String item, int jumlah) {
        if (itemMap.containsKey(item)) {
            int currentJumlah = itemMap.get(item);
            if (currentJumlah > jumlah) {
                itemMap.put(item, currentJumlah - jumlah);
                totalItem -= jumlah;
                return true;
            } else if (currentJumlah == jumlah) {
                return hapusItem(item);
            }
        }
        return false;
    }

    public Map<String, Integer> getItemMap() {
        return itemMap;
    }

    public int getTotalItem() {
        return totalItem;
    }
}
