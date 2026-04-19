// NIM: 13020240115
// Nama: Ihyanul hakim
// Tanggal:  Sabtu, 18 April 2026, Pukul 15:57

import java.util.Scanner;

// Class Buah
class Buah {
    private String nama;
    private int harga;
    private int stok;

    // Konstruktor
    public Buah(String nama, int harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Cek stok & kurangi jika cukup
    public boolean tersedia(int qty) {
        if (stok >= qty) {
            stok -= qty;
            return true;
        } else {
            return false;
        }
    }

    // Hitung total harga
    public int hitungTotal(int qty) {
        return harga * qty;
    }

    // Info buah
    public String getInfo() {
        return nama + "   Rp  " + harga + " (stok:" + stok + " kg)";
    }
}

// Class utama
public class TokoBuah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Array of object
        Buah[] katalog = new Buah[3];

        katalog[0] = new Buah("Apel     ", 15000, 10);
        katalog[1] = new Buah("Jeruk    ", 12000, 8);
        katalog[2] = new Buah("Mangga   ", 20000, 5);

        int pilih;
        int qty;
        int total = 0;

        // Tampilkan katalog
        for (int i = 0; i < katalog.length; i++) {
            System.out.println((i + 1) + ". " + katalog[i].getInfo());
        }

        // Proses belanja
        while (true) {
            System.out.print("Pilih (0=stop): ");
            pilih = sc.nextInt();

            if (pilih == 0) {
                break;
            }

            System.out.print("Jumlah(kg): ");
            qty = sc.nextInt();

            if (katalog[pilih - 1].tersedia(qty)) {
                int harga = katalog[pilih - 1].hitungTotal(qty);
                total += harga;
                System.out.println("Rp" + harga);
            } else {
                System.out.println("Stok tidak cukup!");
            }
        }

        System.out.println("Total: Rp" + total);

        sc.close();
    }
}