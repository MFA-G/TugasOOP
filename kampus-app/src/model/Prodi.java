package model;

public class Prodi {
    private int id;
    private String namaProdi;

    public Prodi(int id, String namaProdi) {
        this.id = id;
        this.namaProdi = namaProdi;
    }

    public int getId() {
        return id;
    }

    public String getNamaProdi() {
        return namaProdi;
    }
}
