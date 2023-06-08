package web.projekat.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import web.projekat.entity.Status;
import web.projekat.entity.ZahtevZaPrihvatanjeAutora;

public class ZahtevZaPrihvatanjeAutoraDto {
    private Long id;
    private String email;
    private String telefon;
    private String poruka;
    private String datum;
    private Status status;

    public ZahtevZaPrihvatanjeAutoraDto(){}
    public ZahtevZaPrihvatanjeAutoraDto(Long id,String email,String telefon,String poruka,String datum,Status status){
        this.id = id;
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.datum = datum;
        this.status = status;
    }
    public ZahtevZaPrihvatanjeAutoraDto(ZahtevZaPrihvatanjeAutora zahtevZaPrihvatanjeAutora){
        this.id = zahtevZaPrihvatanjeAutora.getId();
        this.email = zahtevZaPrihvatanjeAutora.getEmail();
        this.telefon = zahtevZaPrihvatanjeAutora.getTelefon();
        this.poruka = zahtevZaPrihvatanjeAutora.getPoruka();
        this.datum = zahtevZaPrihvatanjeAutora.getDatum();
        this.status = zahtevZaPrihvatanjeAutora.getStatus();
    }

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
}
