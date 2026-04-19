// NIM: 13020240115
// Nama: Ihyanul Hakim
// Tanggal: Sabtu, 18 April 2026, Pukul 14:10

import java.util.Scanner;

// Class Mahasiswa
class Mahasiswa {
    private String nama;
    private String nim;
    private int jumlahMK;
    private int[] nilai;

    // Konstruktor
    public Mahasiswa(String nama, String nim, int jumlahMK) {
        this.nama = nama;
        this.nim = nim;
        this.jumlahMK = jumlahMK;
        this.nilai = new int[jumlahMK]; // alokasi array
    }

    // Input nilai
    public void inputNilai(Scanner sc) {
        for (int i = 0; i < jumlahMK; i++) {
            System.out.print("Nilai MK-" + (i + 1) + ": ");
            nilai[i] = sc.nextInt();
        }
    }

    // Hitung rata-rata
    public double hitungRataRata() {
        int total = 0;
        for (int i = 0; i < jumlahMK; i++) {
            total += nilai[i];
        }
        return (double) total / jumlahMK;
    }

    // Tentukan grade
    public char tentukanGrade() {
        double avg = hitungRataRata();

        if (avg >= 85) return 'A';
        else if (avg >= 75) return 'B';
        else if (avg >= 60) return 'C';
        else return 'D';
    }

    // Status lulus
    public boolean lulus() {
        return hitungRataRata() >= 60.0;
    }

    // Tampilkan rapor
    public void tampilRapor() {
        System.out.println("\n=== RAPOR ===");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        System.out.println("Nilai:");

        for (int i = 0; i < jumlahMK; i++) {
            System.out.println("MK-" + (i + 1) + " : " + nilai[i]);
        }

        System.out.printf("Rata  : %.2f\n", hitungRataRata());
        System.out.println("Grade : " + tentukanGrade());
        System.out.println("Lulus : " + lulus());
    }
}

// Class utama
public class DataMahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nama, nim;
        int jumlahMK;

        // Input data mahasiswa
        System.out.print("Nama  : ");
        nama = sc.nextLine();

        System.out.print("NIM   : ");
        nim = sc.nextLine();

        System.out.print("Jml MK: ");
        jumlahMK = sc.nextInt();

        // Buat objek
        Mahasiswa mhs = new Mahasiswa(nama, nim, jumlahMK);

        // Input nilai
        mhs.inputNilai(sc);

        // Tampilkan rapor
        mhs.tampilRapor();

        sc.close();
    }
}