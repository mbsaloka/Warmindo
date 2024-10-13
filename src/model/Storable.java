package model;

public interface Storable {
    boolean tambahItem(String item, int jumlah);
    boolean hapusItem(String item);
    String tampilkanItem();
}
