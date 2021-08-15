public class Musteri {          // Müşteri sınıfı

    private int musteri_ID;      // ve gerekli olan değişkenler
    private String kiralama_Saati;

    public Musteri(int musteri_ID, String kiralama_Saati) {   // Constructor
        this.musteri_ID = musteri_ID;
        this.kiralama_Saati = kiralama_Saati;
    }

    public int getMusteri_ID() {   // Getter ve Setterler
        return musteri_ID;
    }

    public void setMusteri_ID(int musteri_ID) {
        this.musteri_ID = musteri_ID;
    }

    public String getKiralama_Saati() {
        return kiralama_Saati;
    }

    public void setKiralama_Saati(String kiralama_Saati) {
        this.kiralama_Saati = kiralama_Saati;
    }

    @Override
    public String toString() {     // Override lı toString methodu
        return "Müşterinin ID'si: " + String.format("%3s",getMusteri_ID()) + " -- Kiralama saati: " + String.format("%7s",getKiralama_Saati());
    }
}
