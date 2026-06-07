package praktikum.entitas;

public class Penilaian {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilaiTugas;
    double nilaiUTS;
    double nilaiUAS;
    double nilaiAkhir;
    
    public Penilaian(Mahasiswa mhs, MataKuliah mk, double tugas, double uts, double uas){
        this.mahasiswa = mhs;
        this.mataKuliah = mk;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
        this.nilaiAkhir = (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }
    
    public void tampilPenilaian(){
        System.out.println("NIM: " + mahasiswa.NIM);
        System.out.println("Nama: " + mahasiswa.Nama);
        System.out.println("Kode MK: " + mataKuliah.kodeMK);
        System.out.println("Nama MK: " + mataKuliah.namaMK);
        System.out.println("Nilai Tugas: " + nilaiTugas);
        System.out.println("Nilai UTS: " + nilaiUTS);
        System.out.println("Nilai UAS: " + nilaiUAS);
        System.out.println("Nilai Akhir: " + nilaiAkhir);
        System.out.println();
    }
    
    public double getNilaiAkhir(){
        return nilaiAkhir;
    }
    
    public Mahasiswa getMahasiswa(){
        return mahasiswa;
    }
}
