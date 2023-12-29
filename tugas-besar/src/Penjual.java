import java.util.ArrayList;
import java.util.Scanner;

public class Penjual {
  private ArrayList<String> listUsername = new ArrayList<>();
  private ArrayList<String> listPassword = new ArrayList<>();
  private String userPenjual;
  private String passwordPenjual;
  Scanner scanner = new Scanner(System.in);

  public void metodeMasuk() {
    System.out.println("\nSilahkan pilih metode masuk:");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Kembali");
    System.out.print("Masukkan pilihan Anda: ");
    int pilih = scanner.nextInt();
    scanner.nextLine();
    System.out.println();
    if (pilih == 1) {
      login();
    } else if (pilih == 2) {
      register();
    } else if (pilih == 3) {
      App.menu();
    } else {
      System.out.println("Pilihan tidak tersedia");
    }
  }

  public void login() {
    boolean login = false;
    System.out.println("Login sebagai penjual");
    System.out.print("Username: ");
    userPenjual = scanner.nextLine();
    System.out.print("Password: ");
    passwordPenjual = scanner.nextLine();
    for (int i = 0; i < listUsername.size(); i++) {
      if (listUsername.get(i).equals(userPenjual) && listPassword.get(i).equals(passwordPenjual)) {
        login = true;
        break;
      }
    }
    if (login) {
      menuPenjual();
    } else {
      System.out.println("\nUsername atau password salah\n");
      metodeMasuk();
    }
  }

  public void register() {
    System.out.println("Register sebagai penjual");
    System.out.print("Username: ");
    userPenjual = scanner.nextLine();
    System.out.print("Password: ");
    passwordPenjual = scanner.nextLine();
    listUsername.add(userPenjual);
    listPassword.add(passwordPenjual);
    menuPenjual();
  }

  public void menuPenjual() {
    System.out.println("\nSilahkan pilih menu:");
    System.out.println("1. Tambah menu");
    System.out.println("2. Edit menu");
    System.out.println("3. Hapus menu");
    System.out.println("4. Lihat menu");
    System.out.println("5. Logout");
    System.out.print("Masukkan pilihan Anda: ");
    int pilih = scanner.nextInt();
    scanner.nextLine();
    switch (pilih) {
      case 1:
        tambahMenu();
        break;
      case 2:
        editMenu();
        break;
      case 3:
        hapusMenu();
        break;
      case 4:
        lihatMenu();
        break;
      case 5:
        metodeMasuk();
        break;
      default:
        System.out.println("Pilihan tidak tersedia");
        break;
    }
  }

  public void tambahMenu() {
    System.out.println("\nTambah menu");
    System.out.print("Nama menu: ");
    String namaMenu = scanner.nextLine();
    System.out.print("Harga: ");
    int harga = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Stok: ");
    int stok = scanner.nextInt();
    scanner.nextLine();
    try {
      Menu menu = new Menu(this.userPenjual, namaMenu, harga, stok);
      App.sharedMenuList.add(menu);
      System.out.println("\nMenu berhasil ditambahkan");
    } catch (Exception e) {
      System.err.println("Menu gagal ditambahkan");
    }
    menuPenjual();
  }

  public void editMenu() {
    System.out.println("\nEdit menu");
    System.out.print("Masukkan nama menu yang ingin diedit: ");
    String namaMenu = scanner.nextLine();

    Menu menuYangInginDiedit = null;
    for (Menu menu : App.sharedMenuList) {
      if (menu.getNamaMenu().equals(namaMenu) && menu.getPemilik().equals(this.userPenjual)) {
        menuYangInginDiedit = menu;
        break;
      }
    }

    if (menuYangInginDiedit == null) {
      System.out.println("Menu tidak ditemukan");
      menuPenjual();
    }

    System.out.println("Pilih atribut yang ingin diedit:");
    System.out.println("1. Nama");
    System.out.println("2. Harga");
    System.out.println("3. Stok");
    System.out.print("Masukkan pilihan Anda: ");
    int pilihan = scanner.nextInt();
    scanner.nextLine();

    switch (pilihan) {
      case 1:
        System.out.print("Masukkan nama menu baru: ");
        String namaBaru = scanner.nextLine();
        menuYangInginDiedit.setNamaMenu(namaBaru);
        break;
      case 2:
        System.out.print("Masukkan harga baru: ");
        int hargaBaru = scanner.nextInt();
        scanner.nextLine();
        menuYangInginDiedit.setHarga(hargaBaru);
        break;
      case 3:
        System.out.print("Masukkan stok baru: ");
        int stokBaru = scanner.nextInt();
        scanner.nextLine();
        menuYangInginDiedit.setStok(stokBaru);
        break;
      default:
        System.out.println("Pilihan tidak valid.");
        menuPenjual();
    }

    System.out.println("Menu berhasil diedit.");
    menuPenjual();
  }

  public void hapusMenu() {
    System.out.println("\nHapus menu");
    System.out.print("Nama menu yang ingin dihapus: ");
    String namaMenu = scanner.nextLine();

    for (int i = 0; i < App.sharedMenuList.size(); i++) {
      Menu menu = App.sharedMenuList.get(i);
      if (menu.getNamaMenu().equals(namaMenu) && menu.getPemilik().equals(this.userPenjual)) {
        App.sharedMenuList.remove(i);
        System.out.println("\nMenu " + namaMenu + " berhasil dihapus.");
        menuPenjual();
      }
    }
    System.out.println("Menu tidak ditemukan atau anda tidak memiliki hak untuk menghapus menu ini.");
    menuPenjual();
  }

  public void lihatMenu() {
    boolean adaMenu = false;
    System.out.println("\nMenu anda");
    for (Menu menu : App.sharedMenuList) {
      if (menu.getPemilik().equals(this.userPenjual)) {
        System.out
            .println("Nama menu: " + menu.getNamaMenu() + "\tharga: " + menu.getHarga() + "\tstok: " + menu.getStok());
        adaMenu = true;
      }
    }
    if (!adaMenu) {
      System.out.println("Anda belum menambahkan menu.");
    }
    menuPenjual();
  }
}