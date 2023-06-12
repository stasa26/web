package web.projekat.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Stavka implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Recenzija recenzija;

    @ManyToOne(fetch = FetchType.EAGER)
    private Knjiga knjiga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return "Stavka{" +
                "id=" + id +
                ", recenzija='" + recenzija.getOcena() + '\'' +
                ", knjiga='" + knjiga.getNaslov() + '\''  +
                '}';
    }
}
