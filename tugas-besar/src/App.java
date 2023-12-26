import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static ArrayList<Menu> sharedMenuList = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		menu();
	}

	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("<--------------------------->");
		System.out.println("Selamat datang di FadhlanFood");
		System.out.println("\nSilahkan pilih menu:");
		System.out.println("1. Untuk Pembeli");
		System.out.println("2. Untuk Penjual");
		System.out.println("<--------------------------->\n");
		System.out.print("Masukkan pilihan Anda: ");
		int pilih = scanner.nextInt();
		switch (pilih) {
			case 1:
				Pembeli pembeli = new Pembeli();
				pembeli.metodeMasuk();
				break;
			case 2:
				Penjual penjual = new Penjual();
				penjual.metodeMasuk();
				break;
			default:
				System.out.println("Pilihan tidak tersedia");
				break;
		}
		scanner.close();
	}
}