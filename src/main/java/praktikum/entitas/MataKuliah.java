package praktikum.entitas;

public class MataKuliah {
    public String kodeMK;
    public String namaMK;
    public int sks;
    
    public MataKuliah(String kodemk, String namamk, int sks){
        this.kodeMK = kodemk;
        this.namaMK = namamk;
        this.sks = sks;
    }
    
    public void tampilMataKuliah(){
        System.out.println("Kode MataKuliah: " + kodeMK);
        System.out.println("Nama MataKuliah: " + namaMK);
        System.out.println("Jumlah SKS: " + sks);
    }
}
