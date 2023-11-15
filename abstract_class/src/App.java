public class App {
    public static void main(String[] args) {
        Gitar gitar = new Gitar();
        Piano piano = new Piano();
        Terompet terompet = new Terompet();

        piano.suara();
        terompet.suara();
        gitar.suara();

        piano.caraMain();
        terompet.caraMain();
        gitar.caraMain();
    
    }
}
