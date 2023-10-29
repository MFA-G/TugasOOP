package model;

import java.util.ArrayList;

public class DBTables {
    public ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    public ArrayList<Prodi> dataProdi = new ArrayList<>();

    public DBTables() {
        dataProdi.add(new Prodi(1, "Teknik Informatika"));
        dataProdi.add(new Prodi(2, "Sistem Informasi"));
        dataProdi.add(new Prodi(3, "Teknik Komputer"));
        dataProdi.add(new Prodi(4, "Teknik Elektro"));
        dataProdi.add(new Prodi(5, "Teknik Telekomunikasi"));
    }
}
