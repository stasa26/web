package web.projekat.dto;

import web.projekat.entity.Korisnik;
import web.projekat.entity.Polica;

public class PolicaDto {
    private Long id;
    private String naziv;
    private Boolean primarna;
    private Long korisnik;
    public PolicaDto() {}
    public PolicaDto(Long id,String naziv,Boolean primarna,Long korisnik){
        this.id = id;
        this.naziv = naziv;
        this.korisnik = korisnik;
        this.primarna = primarna;
    }
    public PolicaDto(Polica polica){
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna = polica.getPrimarna();

    }
    public Long getId(){
        return id;
    }
    public String getNaziv(){
        return naziv;
    }
    public Boolean getPrimarna(){
        return primarna;
    }
    public Long getKorisnik(){
        return korisnik;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setNaziv(String naziv){
        this.naziv = naziv;
    }
    public void setPrimarna(Boolean primarna){
        this.primarna = primarna;
    }
    public void setKorisnik(Long korisnik){
        this.korisnik = korisnik;
    }
}
