public class Main {
    public static void main(String[] args) {
        FormulirMahasiswa peserta_01 = new FormulirMahasiswa(); 
        peserta_01.nama = "Rei";
        System.out.println(peserta_01.nama);
        peserta_01.noHP = "01";
        System.out.println(peserta_01.noHP);
        peserta_01.kelas = "SI";
        peserta_01.caraPembayaran();
        peserta_01.Prodi();       

        FormulirDosen peserta_02 = new FormulirDosen();
        peserta_02.nama = "Tpoer";
        System.out.println(peserta_02.nama);
        peserta_02.kodeDosen = "00";
        System.out.println(peserta_02.kodeDosen);
        peserta_02.caraPembayaran();
        peserta_02.Prodi();
    }   
}
