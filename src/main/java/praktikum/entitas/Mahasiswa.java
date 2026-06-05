package praktikum.entitas;

public class Mahasiswa {
    String NIM;
    String Nama;
    String Prodi;
    
    public Mahasiswa(String nim, String nama, String prodi){
        this.NIM = nim;
        this.Nama = nama;
        this.Prodi = prodi;
    }
    
    public void tampilMahasiswa(){
        System.out.println("NIM Mahasiswa: " + NIM);
        System.out.println("Nama Mahasiswa: " + Nama);
        System.out.println("Nama Prodi: " + Prodi);
    }
}
