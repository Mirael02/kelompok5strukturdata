package praktikum;

import java.util.Scanner;
import praktikum.entitas.Mahasiswa;
import praktikum.entitas.MataKuliah;
import praktikum.entitas.Penilaian;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Data mahasiswa menggunakan array
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[4];
        daftarMahasiswa[0] = new Mahasiswa("001", "Ahmad Rizki", "Informatika");
        daftarMahasiswa[1] = new Mahasiswa("002", "Siti Nurhaliza", "Sistem Informasi");
        daftarMahasiswa[2] = new Mahasiswa("003", "Budi Santoso", "Teknik Komputer");
        daftarMahasiswa[3] = new Mahasiswa("004", "Dewi Lestari", "Informatika");
        
        // Data mata kuliah menggunakan array
        MataKuliah[] daftarMataKuliah = new MataKuliah[4];
        daftarMataKuliah[0] = new MataKuliah("IF001", "Pemrograman Dasar", 3);
        daftarMataKuliah[1] = new MataKuliah("IF002", "Struktur Data", 4);
        daftarMataKuliah[2] = new MataKuliah("IF003", "Algoritma", 3);
        daftarMataKuliah[3] = new MataKuliah("SI001", "Sistem Basis Data", 4);
        
        // Data penilaian menggunakan array
        Penilaian[] daftarPenilaian = new Penilaian[4];
        daftarPenilaian[0] = new Penilaian(daftarMahasiswa[0], daftarMataKuliah[0], 85, 80, 90);
        daftarPenilaian[1] = new Penilaian(daftarMahasiswa[1], daftarMataKuliah[0], 90, 88, 92);
        daftarPenilaian[2] = new Penilaian(daftarMahasiswa[2], daftarMataKuliah[1], 78, 75, 80);
        daftarPenilaian[3] = new Penilaian(daftarMahasiswa[3], daftarMataKuliah[2], 88, 85, 89);
        
        int pilihan;
        do {
            System.out.println("\n=== MENU PROGRAM ===");
            System.out.println("1. Menampilkan daftar mahasiswa");
            System.out.println("2. Menampilkan daftar mata kuliah");
            System.out.println("3. Menampilkan daftar penilaian");
            System.out.println("4. Urutan mahasiswa berdasarkan nilai akhir");
            System.out.println("5. Cari mahasiswa berdasarkan NIM");
            System.out.println("6. Keluar dari program");
            System.out.print("Masukkan pilihan (1-6): ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid. Masukkan angka (1-6): ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (pilihan) {
                case 1:
                    tampilkanDaftarMahasiswa(daftarMahasiswa);
                    break;
                case 2:
                    tampilkanDaftarMataKuliah(daftarMataKuliah);
                    break;
                case 3:
                    tampilkanDaftarPenilaian(daftarPenilaian);
                    break;
                case 4:
                    urutkanMahasiswaBerdasarkanNilai(daftarPenilaian);
                    break;
                case 5:
                    cariMahasiswaBerdasarkanNIM(scanner, daftarMahasiswa);
                    break;
                case 6:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
            }
        } while (pilihan != 6);
        
        scanner.close();
    }
    
    private static void tampilkanDaftarMahasiswa(Mahasiswa[] daftarMahasiswa) {
        System.out.println("\n=== DAFTAR MAHASISWA ===");
        boolean adaData = false;
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null) {
                Mahasiswa mhs = daftarMahasiswa[i];
                System.out.println((i + 1) + ". NIM: " + mhs.NIM + ", Nama: " + mhs.Nama + ", Prodi: " + mhs.Prodi);
                adaData = true;
            }
        }
        if (!adaData) {
            System.out.println("Tidak ada data mahasiswa.");
        }
    }
    
    private static void tampilkanDaftarMataKuliah(MataKuliah[] daftarMataKuliah) {
        System.out.println("\n=== DAFTAR MATA KULIAH ===");
        boolean adaData = false;
        for (int i = 0; i < daftarMataKuliah.length; i++) {
            if (daftarMataKuliah[i] != null) {
                MataKuliah mk = daftarMataKuliah[i];
                System.out.println((i + 1) + ". Kode: " + mk.kodeMK + ", Nama: " + mk.namaMK + ", SKS: " + mk.sks);
                adaData = true;
            }
        }
        if (!adaData) {
            System.out.println("Tidak ada data mata kuliah.");
        }
    }
    
    private static void tampilkanDaftarPenilaian(Penilaian[] daftarPenilaian) {
        System.out.println("\n=== DAFTAR PENILAIAN ===");
        boolean adaData = false;
        for (int i = 0; i < daftarPenilaian.length; i++) {
            if (daftarPenilaian[i] != null) {
                System.out.println("Penilaian ke-" + (i + 1) + ":");
                daftarPenilaian[i].tampilPenilaian();
                adaData = true;
            }
        }
        if (!adaData) {
            System.out.println("Tidak ada data penilaian.");
        }
    }
    
    private static void urutkanMahasiswaBerdasarkanNilai(Penilaian[] daftarPenilaian) {
        System.out.println("\n=== URUTAN MAHASISWA BERDASARKAN NILAI AKHIR ===");
        
        // Hitung jumlah data yang valid
        int jumlahData = 0;
        for (int i = 0; i < daftarPenilaian.length; i++) {
            if (daftarPenilaian[i] != null) {
                jumlahData++;
            }
        }
        
        if (jumlahData == 0) {
            System.out.println("Tidak ada data penilaian.");
            return;
        }
        
        // Salin data ke array baru untuk sorting
        Penilaian[] sortedPenilaian = new Penilaian[jumlahData];
        int index = 0;
        for (int i = 0; i < daftarPenilaian.length; i++) {
            if (daftarPenilaian[i] != null) {
                sortedPenilaian[index] = daftarPenilaian[i];
                index++;
            }
        }
        
        // Sorting menggunakan Bubble Sort (descending berdasarkan nilai akhir)
        for (int i = 0; i < sortedPenilaian.length - 1; i++) {
            for (int j = 0; j < sortedPenilaian.length - i - 1; j++) {
                if (sortedPenilaian[j].getNilaiAkhir() < sortedPenilaian[j + 1].getNilaiAkhir()) {
                    // Tukar posisi
                    Penilaian temp = sortedPenilaian[j];
                    sortedPenilaian[j] = sortedPenilaian[j + 1];
                    sortedPenilaian[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Ranking | NIM      | Nama                  | Nilai Akhir");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < sortedPenilaian.length; i++) {
            Penilaian p = sortedPenilaian[i];
            Mahasiswa mhs = p.getMahasiswa();
            System.out.printf("%d         | %-8s | %-21s | %.2f%n", 
                (i + 1), mhs.NIM, mhs.Nama, p.getNilaiAkhir());
        }
    }
    
    private static void cariMahasiswaBerdasarkanNIM(Scanner scanner, Mahasiswa[] daftarMahasiswa) {
        System.out.print("\nMasukkan NIM yang ingin dicari: ");
        String nimDicari = scanner.nextLine().trim();
        
        boolean ditemukan = false;
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i] != null && daftarMahasiswa[i].NIM.equalsIgnoreCase(nimDicari)) {
                System.out.println("\n=== DATA MAHASISWA DITEMUKAN ===");
                System.out.println("NIM: " + daftarMahasiswa[i].NIM);
                System.out.println("Nama: " + daftarMahasiswa[i].Nama);
                System.out.println("Prodi: " + daftarMahasiswa[i].Prodi);
                ditemukan = true;
                break;
            }
        }
        
        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nimDicari + " tidak ditemukan.");
        }
    }
}