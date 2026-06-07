package praktikum.entitas;

public class Mahasiswa {
    public String NIM;
    public String Nama;
    public String Prodi;
    
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
