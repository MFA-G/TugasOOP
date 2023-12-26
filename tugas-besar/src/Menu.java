public class Menu {
  private String pemilik;
  private String namaMenu;
  private int harga;
  private int stok;

  public Menu(String pemilik, String namaMenu, int harga, int stok) {
    this.pemilik = pemilik;
    this.namaMenu = namaMenu;
    this.harga = harga;
    this.stok = stok;
  }

  public String getPemilik() {
    return pemilik;
  }

  public String getNamaMenu() {
    return namaMenu;
  }

  public int getHarga() {
    return harga;
  }

  public int getStok() {
    return stok;
  }

  public void setPemilik(String pemilik) {
    this.pemilik = pemilik;
  }

  public void setNamaMenu(String namaMenu) {
    this.namaMenu = namaMenu;
  }

  public void setHarga(int harga) {
    this.harga = harga;
  }

  public void setStok(int stok) {
    this.stok = stok;
  }
}
