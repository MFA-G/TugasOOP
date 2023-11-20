public abstract class FormulirBase {
    public String nama;
    public String noHP;

    public void caraPembayaran() {
        System.out.println("Tata cara bayar untuk " + nama);
    }
   
    public abstract void absensi();
}
