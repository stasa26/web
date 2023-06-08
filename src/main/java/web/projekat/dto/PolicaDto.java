package web.projekat.dto;

import web.projekat.entity.Korisnik;

public class PolicaDto {
    private Long id;
    private String naziv;
    private Boolean primarna;
    private Korisnik korisnik;
    public PolicaDto() {};
    public PolicaDto(Long id,String naziv,Boolean primarna,Korisnik korisnik){
        this.id = id;
        this.naziv = naziv;
        this.korisnik = korisnik;
    }
    public PolicaDto(PolicaDto polica){
        this.id = polica.getId();
        this.naziv = polica.getNaziv();
        this.primarna = polica.getPrimarna();
        this.korisnik = polica.getKorisnik();

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
    public Korisnik getKorisnik(){
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
    public void setKorisnik(Korisnik korisnik){
        this.korisnik = korisnik;
    }
}
