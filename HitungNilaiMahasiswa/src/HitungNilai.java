import java.util.Scanner;

public class HitungNilai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama  : ");
        String nama = scanner.nextLine();
        System.out.print("NIM   : ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan nilai Tubes: ");
        double nilaiTubes = scanner.nextDouble();
        System.out.print("Masukkan nilai Quiz: ");
        double nilaiQuiz = scanner.nextDouble();
        System.out.print("Masukkan nilai Tugas: ");
        double nilaiTugas = scanner.nextDouble();
        System.out.print("Masukkan nilai UTS: ");
        double nilaiUTS = scanner.nextDouble();
        System.out.print("Masukkan nilai UAS: ");
        double nilaiUAS = scanner.nextDouble();
        double totalNilai = (0.3 * nilaiTubes) + (0.1 * nilaiQuiz) + (0.1 * nilaiTugas) + (0.25 * nilaiUTS) + (0.25 * nilaiUAS);
        System.out.println("\n-------------------");
        System.out.println("Nama  : " + nama);
        System.out.println("NIM   : " + nim);
        System.out.println("Nilai Matakuliah Pemograman Berorientasi Objek : " + totalNilai);
        System.out.println("-------------------");
        scanner.close();
    }
}
