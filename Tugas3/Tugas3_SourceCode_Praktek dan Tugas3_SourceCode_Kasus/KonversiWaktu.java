// NIM: 13020240115
// Nama: Ihyanul Hakim
// Tanggal: Sabtu, 18 April 2026, Pukul 17:20
import java.util.Scanner;

// Class bantu
class Konversi {
    private long totalDetik;
    private long detikSekarang;
    private long totalMenit;
    private long menitSekarang;
    private long totalJam;
    private long jamSekarang;

    public Konversi(long totalDetik) {
        this.totalDetik = totalDetik;
    }

    public void hitung() {
        detikSekarang = totalDetik % 60;
        totalMenit = totalDetik / 60;

        menitSekarang = totalMenit % 60;
        totalJam = totalMenit / 60;

        jamSekarang = totalJam % 24;
    }

    public void tampil() {
        System.out.println("=================");
        System.out.printf("Waktu: %02d:%02d:%02d\n", jamSekarang, menitSekarang, detikSekarang);
        System.out.println("=================");

        System.out.println("Total Detik : " + totalDetik);
        System.out.println("detik Saat ini : " + detikSekarang);
        System.out.println("menit Saat ini : " + menitSekarang);
        System.out.println("jam Saat ini : " + jamSekarang);
    }

    public static String konversiCepat(long detik) {
        long d = detik % 60;
        long m = (detik / 60) % 60;
        long j = (detik / 3600) % 24;

        return String.format("%02d:%02d:%02d", j, m, d);
    }
}

// Class utama (HARUS sama dengan nama file)
public class KonversiWaktu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Total detik: ");
        long totalDetik = sc.nextLong();

        Konversi k = new Konversi(totalDetik);
        k.hitung();
        k.tampil();

        System.out.println("--- Contoh lain ---");
        System.out.println("Input : 3661");
        System.out.println("Output: " + Konversi.konversiCepat(3661));
        System.out.println("Input : 86400");
        System.out.println("Output: " + Konversi.konversiCepat(86400) + " (tepat 1 hari)");

        sc.close();
    }
}