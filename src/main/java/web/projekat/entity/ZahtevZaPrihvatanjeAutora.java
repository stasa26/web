package web.projekat.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ZahtevZaPrihvatanjeAutora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String telefon;
    private String poruka;
    private String datum;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ZahtevZaPrihvatanjeAutora{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", datum='" + datum + '\'' +
                ", status=" + status +
                '}';
    }
}
