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
@Table(name = "pardavimai")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pardavimai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int kiekis;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PREKE_ID")
    private Preke preke;

    public Pardavimai() {
    }

    public Long getId() {
        return id;
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

    public Pardavimai(int kiekis) {
        this.kiekis = kiekis;
    }

    public void setPreke(Preke preke) {
        this.preke = preke;
    }

    @Override
    public String toString() {
        return  preke +
                ", Kiekis : " +
                kiekis;
    }
}
