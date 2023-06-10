package web.projekat.dto;

import web.projekat.entity.Knjiga;
import web.projekat.entity.Zanr;

import java.util.HashSet;
import java.util.Set;

public class KnjigaDto {
    private String naslov;
    private String ISBN;
    private String objavljena;
    private Long brojStrana;
    private String opis;

    public KnjigaDto(){
    }
    public KnjigaDto(String naslov,String ISBN,String objavljena,Long brojStrana,String opis){
        this.naslov = naslov;
        this.ISBN = ISBN;
        this.objavljena = objavljena;
        this.brojStrana = brojStrana;
        this.opis = opis;
    }
    public KnjigaDto(Knjiga knjiga){
        this.naslov = knjiga.getNaslov();
        this.ISBN = knjiga.getISBN();
        this.objavljena = knjiga.getObjavljena();
        this.brojStrana = knjiga.getBrojStrana();
        this.opis = knjiga.getOpis();
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
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
}

