package repository;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.DBTables;
import model.Mahasiswa;
import model.Prodi;

public class Database {
    private Gson gson;
    private String namaFileDataMahasiswa = "db_kampusapp";
    public DBTables tables = new DBTables();
    public MahasiswaTbl mahasiswaTbl = new MahasiswaTbl(this);

    public Database() {
        gson = new Gson();
        readDBFile();
    }

    protected void commit() {
        try (PrintWriter writer = new PrintWriter(new File(namaFileDataMahasiswa))) {
            writer.println(gson.toJson(tables.dataMahasiswa));
            writer.println();
            writer.println(gson.toJson(tables.dataProdi));
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file: " + e.getMessage());
        }
    }    

    private void readDBFile() {
    try (Scanner scanner = new Scanner(new File(namaFileDataMahasiswa))) {
        if(scanner.hasNextLine()) {
            String mahasiswaJson = scanner.nextLine();
            tables.dataMahasiswa = gson.fromJson(mahasiswaJson, new TypeToken<ArrayList<Mahasiswa>>(){}.getType());
        }
        
        if(scanner.hasNextLine()) { // skip the empty line
            scanner.nextLine();
        }

        if(scanner.hasNextLine()) {
            String prodiJson = scanner.nextLine();
            tables.dataProdi = gson.fromJson(prodiJson, new TypeToken<ArrayList<Prodi>>(){}.getType());
        }
        } catch (IOException e) {
        }
    }

}
