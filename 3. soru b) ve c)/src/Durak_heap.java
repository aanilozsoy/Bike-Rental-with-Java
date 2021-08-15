public class Durak_heap{ //Heap yapısında durakları kullanabilmek için tıpatıp aynı Durak sınıfı burada da yazdım

    private String durakAdi;
    private int bos_Park_sayisi;
    private int tandem_Bisiklet;
    private int normal_Bisiklet;

    public Durak_heap(String durakAdi, int bos_Park_sayisi, int tandem_Bisiklet, int normal_Bisiklet) {

        this.durakAdi = durakAdi;
        this.bos_Park_sayisi = bos_Park_sayisi;
        this.tandem_Bisiklet = tandem_Bisiklet;
        this.normal_Bisiklet = normal_Bisiklet;

    }

    public String getDurakAdi() {
        return durakAdi;
    }

    public void setDurakAdi(String durakAdi) {
        this.durakAdi = durakAdi;
    }

    public int getBos_Park_sayisi() {
        return bos_Park_sayisi;
    }

    public void setBos_Park_sayisi(int bosPark) {
        this.bos_Park_sayisi = bosPark;
    }

    public int getTandemBisiklet() {
        return tandem_Bisiklet;
    }

    public void setTandemBisiklet(int tandemBisiklet) {
        this.tandem_Bisiklet = tandemBisiklet;
    }

    public int getNormalBisiklet() {
        return normal_Bisiklet;
    }

    public void setNormalBisiklet(int normalBisiklet) {
        this.normal_Bisiklet = normalBisiklet;
    }

    @Override
    public String toString() {
        return "Durak adı: " + String.format("%-18s",getDurakAdi()) + "  Normal bisiklet: " + String.format("%3d",getNormalBisiklet()) +"  Tandem bisiklet: " +
                String.format("%3d",getTandemBisiklet())+ " Boş park: " + String.format("%3d",getBos_Park_sayisi());
    }
}


