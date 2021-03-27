package Prekes;

public class Preke {
    private String pavadinimas;
    private String kategorija;
    private String spalva;
    private int kiekis;
    private double kaina;

    public Preke(String pavadinimas, String kategorija, String spalva, int kiekis, double kaina) {
        this.pavadinimas = pavadinimas;
        this.kategorija = kategorija;
        this.spalva = spalva;
        this.kiekis = kiekis;
        this.kaina = kaina;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSpalva() {
        return spalva;
    }

    public void setSpalva(String spalva) {
        this.spalva = spalva;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }
}
