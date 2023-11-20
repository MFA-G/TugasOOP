public class Piano extends AlatMusik{
  private String merek = "Bach";
  private String cara = "Dipencet";
  private String suara = "Tingg.. tingg..";

  @Override
  public void suara(){
    System.out.println("Suara Piano adalah: " + suara);
  }
  public void caraMain(){
    System.out.println("Cara memainkan Piano adalah dengan: " + cara);
  }

  public void merekAlat(){
    System.out.println("Merek piano adalah: " + merek);
  }
}
