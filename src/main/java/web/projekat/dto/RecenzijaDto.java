package web.projekat.dto;

import web.projekat.entity.Korisnik;
import web.projekat.entity.Recenzija;

public class RecenzijaDto {
    private Long id;
    private Double ocena;
    private String tekst;
    private String datum;
    private Korisnik korisnik;
    public RecenzijaDto(){}
    public RecenzijaDto(Long id,Double ocena,String tekst,String datum,Korisnik korisnik){
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
        this.korisnik = recenzija.getKorisnik();
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
    public Korisnik getKorisnik(){
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

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
