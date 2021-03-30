package Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PARDUOTUVE")
public class Parduotuve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY )
    @JoinTable(
            name = "fk_preke_parduotuve",
            joinColumns = { @JoinColumn(name = "prekesid") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    private Set<Parduotuve> prekesid = new HashSet<>();

    @Column
    private int kiekis;

    public Set<Parduotuve> getPrekesid() {
        return prekesid;
    }

    public void setPrekesid(Set<Parduotuve> prekesid) {
        this.prekesid = prekesid;
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

}

