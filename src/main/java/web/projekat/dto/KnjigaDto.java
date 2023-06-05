package web.projekat.dto;

import web.projekat.entity.Knjiga;
import web.projekat.entity.Zanr;

import java.util.HashSet;
import java.util.Set;

public class KnjigaDto {
    private String naslov;
    private String naslovnaFotografija;
    private String ISBN;
    private String objavljena;
    private Long brojStrana;
    private String opis;
    private Double ocena;
    private Knjiga knjiga;
    private Set<Zanr> zanr = new HashSet<Zanr>();

    public KnjigaDto(){
    }
    public KnjigaDto(String naslov,String naslovnaFotografija,String ISBN,String objavljena,Long brojStrana,String opis,Double ocena,Set<Zanr> zanr){
        this.naslov = naslov;
        this.naslovnaFotografija = naslovnaFotografija;
        this.ISBN = ISBN;
        this.objavljena = objavljena;
        this.brojStrana = brojStrana;
        this.opis = opis;
        this.ocena = ocena;
        this.zanr = zanr;
    }
    public KnjigaDto(Knjiga knjiga){
        this.naslov = knjiga.getNaslov();
        this.naslovnaFotografija = knjiga.getNaslovnaFotografija();
        this.ISBN = knjiga.getISBN();
        this.objavljena = knjiga.getObjavljena();
        this.brojStrana = knjiga.getBrojStrana();
        this.opis = knjiga.getOpis();
        this.ocena = knjiga.getOcena();
        this.zanr = knjiga.getZanr();
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslovnaFotografija() {
        return naslovnaFotografija;
    }

    public void setNaslovnaFotografija(String naslovnaFotografija) {
        this.naslovnaFotografija = naslovnaFotografija;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getObjavljena() {
        return objavljena;
    }

    public void setObjavljena(String objavljena) {
        this.objavljena = objavljena;
    }

    public Long getBrojStrana() {
        return brojStrana;
    }

    public void setBrojStrana(Long brojStrana) {
        this.brojStrana = brojStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<Zanr> getZanr() {
        return zanr;
    }

    public void setZanr(Set<Zanr> zanr) {
        this.zanr = zanr;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }
}

