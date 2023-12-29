import java.util.Scanner;
import java.util.ArrayList;

public class Pembeli {
  private ArrayList<String> listUsername = new ArrayList<>();
  private ArrayList<String> listPassword = new ArrayList<>();
  private ArrayList<Menu> keranjangBelanja = new ArrayList<>();
  private String userPembeli;
  private String passwordPembeli;

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
    System.out.println("Login sebagai pembeli");
    System.out.print("Username: ");
    userPembeli = scanner.nextLine();
    System.out.print("Password: ");
    passwordPembeli = scanner.nextLine();
    for (int i = 0; i < listUsername.size(); i++) {
      if (listUsername.get(i).equals(userPembeli) && listPassword.get(i).equals(passwordPembeli)) {
        login = true;
        break;
      }
    }
    if (login) {
      menuPembeli();
    } else {
      System.out.println("\nUsername atau password salah\n");
      metodeMasuk();
    }
  }

  public void register() {
    System.out.println("Register sebagai pembeli");
    System.out.print("Username: ");
    userPembeli = scanner.nextLine();
    System.out.print("Password: ");
    passwordPembeli = scanner.nextLine();
    listUsername.add(userPembeli);
    listPassword.add(passwordPembeli);
    menuPembeli();
  }

  public void menuPembeli() {
    System.out.println("\nSilahkan pilih menu:");
    System.out.println("1. Lihat list menu");
    System.out.println("2. Lihat keranjang");
    System.out.println("3. Checkout");
    System.out.println("4. Logout");
    System.out.print("Masukkan pilihan Anda: ");
    int pilih = scanner.nextInt();
    scanner.nextLine();
    switch (pilih) {
      case 1:
        daftarMenu();
        break;
      case 2:
        lihatKeranjang();
        break;
      case 3:
        checkout();
        ;
        break;
      case 4:
        metodeMasuk();
        break;
      default:
        System.out.println("Pilihan tidak tersedia");
        menuPembeli();
        break;
    }
  }

  public void daftarMenu() {
    boolean adaMenuTersedia = false;
    for (Menu menu : App.sharedMenuList) {
      if (menu.getStok() > 0) {
        System.out
            .println("Nama menu: " + menu.getNamaMenu() + ", harga: " + menu.getHarga() + ", stok: " + menu.getStok());
        adaMenuTersedia = true;
      }
    }
    if (!adaMenuTersedia) {
      System.out.println("Belum ada menu yang tersedia.");
    } else {
      tambahMenu();
    }
    menuPembeli();
  }

  public void tambahMenu() {
    System.out.println("\nPilih menu yang ingin ditambahkan ke keranjang:");
    String namaMenu = scanner.nextLine();
    Menu menuDipilih = null;
    for (Menu menu : App.sharedMenuList) {
      if (menu.getNamaMenu().equalsIgnoreCase(namaMenu)) {
        menuDipilih = menu;
        break;
      }
    }
    if (menuDipilih != null) {
      keranjangBelanja.add(menuDipilih);
      System.out.println("Menu " + namaMenu + " telah ditambahkan ke keranjang.");
    } else {
      System.out.println("Menu tidak ditemukan.");
    }
  }

  public void lihatKeranjang() {
    if (keranjangBelanja.isEmpty()) {
      System.out.println("Keranjang belanja Anda kosong.");
      menuPembeli();
    } else {
      System.out.println("\nKeranjang belanja Anda:");
      for (Menu menu : keranjangBelanja) {
        System.out.println("Nama menu: " + menu.getNamaMenu() + "\tharga: " + menu.getHarga());
      }
      System.out.println("\n1. Hapus menu dari keranjang");
      System.out.println("2. Kembali");
      System.out.print("Masukkan pilihan Anda: ");
      int pilihan = scanner.nextInt();
      scanner.nextLine();
      if (pilihan == 1) {
        hapusMenu();
      } else if (pilihan == 2) {
        menuPembeli();
      } else {
        System.out.println("Pilihan tidak tersedia");
        lihatKeranjang();
      }
    }
  }

  public void hapusMenu() {
    System.out.println("\nMasukkan nama menu yang ingin dihapus:");
    String namaMenu = scanner.nextLine();
    Menu menuYangInginDihapus = null;
    for (Menu menu : keranjangBelanja) {
      if (menu.getNamaMenu().equals(namaMenu)) {
        menuYangInginDihapus = menu;
        break;
      }
    }
    if (menuYangInginDihapus != null) {
      keranjangBelanja.remove(menuYangInginDihapus);
      System.out.println("Menu " + namaMenu + " telah dihapus dari keranjang.");
    } else {
      System.out.println("Menu tidak ditemukan di keranjang.");
    }
    lihatKeranjang();
  }

  public void checkout() {
    if (keranjangBelanja.isEmpty()) {
      System.out.println("Keranjang belanja Anda kosong. Tidak dapat melakukan checkout.");
      menuPembeli();
    } else {
      int totalHarga = 0;
      for (Menu menu : keranjangBelanja) {
        totalHarga += menu.getHarga();
      }
      System.out.println("Total harga pembelian Anda adalah: " + totalHarga);
      for (Menu menu : keranjangBelanja) {
        for (Menu sharedMenu : App.sharedMenuList) {
          if (sharedMenu.equals(menu)) {
            sharedMenu.setStok(sharedMenu.getStok() - 1);
          }
        }
      }

      keranjangBelanja.clear();
      System.out.println("Terima kasih telah melakukan pembelian. Keranjang belanja Anda sekarang kosong.");
      menuPembeli();
    }
  }

}
