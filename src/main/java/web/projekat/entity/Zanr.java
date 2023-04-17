package web.projekat.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Zanr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Zanr{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
