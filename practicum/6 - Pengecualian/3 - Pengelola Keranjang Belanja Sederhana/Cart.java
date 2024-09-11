/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 
import java.util.ArrayList;
import java.util.List;

public class Cart {
    /**
     * Tambahkan atribut kelas disini
     */ 
    private List<Item> items;
    private Account account;

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    public Cart(Account account) {
        items = new ArrayList<Item>();
        this.account = account;
    }
    
    /**
     * Implementasi
     * return account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Implementasi
     * return list item
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Implementasi
     * menambahkan item ke dalam list item
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Implementasi
     * menghapus semua item yang memiliki nama sesuai dengan parameter name
     * 
     * Apabila keranjang kosong, lempar exception "Tidak ada barang di dalam keranjang"
     * Apabila barang tidak ditemukan, lempar exception "Barang tidak ditemukan di dalam keranjang"
     */
    public void removeItem(String name) throws Exception {
        if(items.size() > 0) {
            List<Item> rubbishItems = new ArrayList<Item>();
            for(Item item : items) {
                if(item.getName().equals(name)) {
                    rubbishItems.add(item);
                }
            }
            if(!rubbishItems.isEmpty()) {
                items.removeAll(rubbishItems);
            }
            else {
                throw new Exception("Barang tidak ditemukan di dalam keranjang");
            }
        }
        else {
            throw new Exception("Tidak ada barang di dalam keranjang");
        }
    }

    /**
     * Implementasi
     * mengembalikan total harga semua barang di dalam keranjang
     */
    public int getTotalPrice() {
        int total = 0;
        for(Item item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    /**
     * Implementasi
     * mengurangi saldo sejumlah total harga semua barang
     * mengosongkan keranjang
     * 
     * Apabila keranjang kosong, lempar exception "Keranjang kosong"
     * Apabila saldo tidak mencukupi, lempar exception "Saldo tidak mencukupi untuk melakukan pembayaran"
     */
    public void checkout() throws Exception {
        if(items.size() > 0) {
            if(account.getSaldo() - getTotalPrice() >= 0) {
                account.reduceSaldo(getTotalPrice());
                items.clear();
            }
            else {
                throw new Exception("Saldo tidak mencukupi untuk melakukan pembayaran");
            }
        }
        else {
            throw new Exception("Keranjang kosong");
        }
    }
}