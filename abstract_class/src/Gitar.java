public class Gitar extends AlatMusik {
  private String merek = "Taylor";
  private String cara = "Dipetik";
  private String suara = "Jrenggg...";
  
  public void suara() {
    System.out.println("Suara gitar adalah: " + suara);
  }
  public void caraMain() {
    System.out.println("Cara memainkan gitar adalah dengan: " + cara);
  }

  @Override
  public void merekAlat() {
    System.out.print("Merek gitar adalah: " + merek + " ft. ");
    super.merekAlat();
  }
}
