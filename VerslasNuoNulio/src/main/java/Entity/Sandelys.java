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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "SANDELYS")
public class Sandelys implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY )
    @JoinTable(
            name = "fk_preke_sandelys",
            joinColumns = { @JoinColumn(name = "prekesid") },
            inverseJoinColumns = { @JoinColumn(name = "id") }
    )
    private Set<Sandelys> prekesid = new HashSet<>();

    @Column
    private int kiekis;

    public Set<Sandelys> getPrekesid() {
        return prekesid;
    }

    public void setPrekesid(Set<Sandelys> prekesid) {
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