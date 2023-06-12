package web.projekat.dto;

import web.projekat.entity.Status;
import web.projekat.entity.ZahtevZaPrihvatanjeAutora;

import java.util.Date;

public class ZahtevZaPrihvatanjeAutoraDto {
    private Long id;
    private String email;
    private String telefon;
    private String poruka;
    private Date datum;
    private Status status;
    private Long idAutora;

    public ZahtevZaPrihvatanjeAutoraDto(){}
    public ZahtevZaPrihvatanjeAutoraDto(Long id, String email, String telefon, String poruka, Date datum, Status status, Long idAutora){
        this.id = id;
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.datum = datum;
        this.status = status;
        this.idAutora = idAutora;
    }
    public ZahtevZaPrihvatanjeAutoraDto(ZahtevZaPrihvatanjeAutora zahtevZaPrihvatanjeAutora){
        this.id = zahtevZaPrihvatanjeAutora.getId();
        this.email = zahtevZaPrihvatanjeAutora.getEmail();
        this.telefon = zahtevZaPrihvatanjeAutora.getTelefon();
        this.poruka = zahtevZaPrihvatanjeAutora.getPoruka();
        this.datum = zahtevZaPrihvatanjeAutora.getDatum();
        this.status = zahtevZaPrihvatanjeAutora.getStatus();
        this.idAutora = zahtevZaPrihvatanjeAutora.getAutor().getId();
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

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(Long idAutora) {
        this.idAutora = idAutora;
    }
}
