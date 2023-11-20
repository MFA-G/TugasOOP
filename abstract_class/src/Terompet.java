public class Terompet extends AlatMusik {
  public String suara = "Tonenott...";
  public String merek = "Bösendorfer";
  public String cara = "Ditiup";

  public void suara() {
    System.out.println("Bunyi terompet adalah: " + suara);
  }
  public void caraMain() {
    System.out.println("Cara main terompet adalah dengan " + cara);
  }

  public void caraMain(String caraTambahan) {
    System.out.println("Sebenarnya, cara main terompet adalah dengan ditiup dan juga " + caraTambahan);
  }

  public void merekAlat() {
    System.out.println("Merek terompet adalah: " + merek);
  }
}
