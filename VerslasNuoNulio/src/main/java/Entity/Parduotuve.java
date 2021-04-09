package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parduotuve")
@Inheritance(strategy = InheritanceType.JOINED)
public class Parduotuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kiekis;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PREKE_ID")
    private Preke preke;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  preke +
                ", Kiekis : " +
                kiekis;
    }

    public Parduotuve() {
    }

    public Parduotuve(int kiekis, Preke preke) {
        this.kiekis = kiekis;
        this.preke = preke;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKiekis() {
        return kiekis;
    }

    public void setKiekis(int kiekis) {
        this.kiekis = kiekis;
    }

    public Preke getPreke() {
        return preke;
    }

    public Parduotuve(int kiekis) {
        this.kiekis = kiekis;
    }

    public void setPreke(Preke preke) {
        this.preke = preke;
    }
}