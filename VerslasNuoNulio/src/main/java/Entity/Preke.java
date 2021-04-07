package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity(name = "PREKE")
@Table(name = "preke")
public class Preke implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Pavadinimas")
    private String pavadinimas;

    @Column(name = "Kategorija")
    private String kategorija;

    @Column(name = "Spalva")
    private String spalva;

    @Column(name = "Kaina")
    private double kaina;

    @OneToMany(mappedBy = "preke", cascade = CascadeType.ALL)
    private Collection<Sandelys> sandelysList = new ArrayList<Sandelys>();

    @OneToMany(mappedBy = "preke", cascade = CascadeType.ALL)
    private Collection<Pardavimai> pardavimaiList = new ArrayList<Pardavimai>();

    @OneToMany(mappedBy = "preke", cascade = CascadeType.ALL)
    private Collection<Parduotuve> parduotuveList = new ArrayList<Parduotuve>();

    public Collection<Pardavimai> getPardavimaiList() {
        return pardavimaiList;
    }

    public void setPardavimaiList(Set<Pardavimai> pardavimaiList) {
        this.pardavimaiList = pardavimaiList;
    }

    public Collection<Parduotuve> getParduotuveList() {
        return parduotuveList;
    }

    public void setParduotuveList(Set<Parduotuve> parduotuveList) {
        this.parduotuveList = parduotuveList;
    }

    public Preke(String pavadinimas, String kategorija, String spalva, double kaina) {
        this.pavadinimas = pavadinimas;
        this.kategorija = kategorija;
        this.spalva = spalva;
        this.kaina = kaina;
    }

    public Preke() {
    }

    @Override
    public String toString() {
        return
                "Prekės ID : " + id +
                        ", Pavadinimas : " + pavadinimas +
                        ", Kategorija : " + kategorija  +
                        ", Spalva : " + spalva +
                        ", Kaina : " + kaina;
    }

    public Collection<Sandelys> getSandelysList() {
        return sandelysList;
    }

    public void setSandelysList(Set<Sandelys> sandelysList) {
        this.sandelysList = sandelysList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }
}
