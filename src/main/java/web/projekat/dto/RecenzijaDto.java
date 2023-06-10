package web.projekat.dto;

import web.projekat.entity.Korisnik;
import web.projekat.entity.Recenzija;

public class RecenzijaDto {
    private Long id;
    private Double ocena;
    private String tekst;
    private String datum;
    private Long korisnik;
    public RecenzijaDto(){}
    public RecenzijaDto(Long id,Double ocena,String tekst,String datum,Long korisnik){
        this.id = id;
        this.ocena = ocena;
        this.tekst = tekst;
        this.datum = datum;
        this.korisnik = korisnik;
    }
    public RecenzijaDto(Recenzija recenzija){
        this.id = recenzija.getId();
        this.ocena = recenzija.getOcena();
        this.tekst = recenzija.getTekst();
        this.datum = recenzija.getDatum();
        this.korisnik = recenzija.getKorisnik().getId();
    }
    public Long getId(){
        return id;
    }
    public Double getOcena(){
        return ocena;
    }
    public String getTekst(){
        return tekst;
    }
    public String getDatum(){
        return datum;
    }
    public Long getKorisnik(){
        return korisnik;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setKorisnik(Long korisnik) {
        this.korisnik = korisnik;
    }
}
