// NIM: 13020240115
// Nama: Ihyanul Hakim
// Tanggal: Sabtu, 18 April 2026, Pukul 12:07

import java.util.Scanner;

// Class Kalkulator
class Kalkulator {
    private double angka1;
    private double angka2;
    private char operator;

    // Konstruktor
    public Kalkulator(double angka1, double angka2, char operator) {
        this.angka1 = angka1;
        this.angka2 = angka2;
        this.operator = operator;
    }

    public double tambah() {
        return angka1 + angka2;
    }

    public double kurang() {
        return angka1 - angka2;
    }

    public double kali() {
        return angka1 * angka2;
    }

    // Validasi sesuai pseudocode (di dalam method)
    public double bagi() {
        if (angka2 == 0) {
            System.out.println("Error: pembagian dengan nol!");
            return 0;
        }
        return angka1 / angka2;
    }
}

// Class utama
public class KalkulatorSederhana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double angka1, angka2, hasil = 0;
        char operator;
        char lagi;

        do {
            System.out.print("Angka 1  : ");
            angka1 = sc.nextDouble();

            System.out.print("Angka 2  : ");
            angka2 = sc.nextDouble();

            System.out.print("Operator : ");
            operator = sc.next().charAt(0);

            // Membuat objek
            Kalkulator k = new Kalkulator(angka1, angka2, operator);

            // Proses sesuai pseudocode
            switch (operator) {
                case '+':
                    hasil = k.tambah();
                    break;
                case '-':
                    hasil = k.kurang();
                    break;
                case '*':
                    hasil = k.kali();
                    break;
                case '/':
                    hasil = k.bagi();
                    break;
                default:
                    System.out.println("Operator tidak dikenal");
                    hasil = 0;
            }

            // Output sesuai format PPT
            System.out.printf("Hasil: %.2f %c %.2f = %.2f\n", angka1, operator, angka2, hasil);

            System.out.print("Hitung lagi? (y/n): ");
            lagi = sc.next().charAt(0);

        } while (lagi == 'y');

        System.out.println("Program selesai.");
        sc.close();
    }
}