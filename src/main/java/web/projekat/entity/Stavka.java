package web.projekat.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Stavka implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recenzija;
    private String knjiga;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(String recenzija) {
        this.recenzija = recenzija;
    }

    public String getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(String knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return "Stavka{" +
                "id=" + id +
                ", recenzija='" + recenzija + '\'' +
                ", knjiga='" + knjiga + '\'' +
                '}';
    }
}
