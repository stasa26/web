package web.projekat.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Knjiga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naslov;
    private String naslovnaFotografija;
    private String ISBN;
    private String objavljena;
    private Long brojStrana;
    private String opis;
    private Double ocena;

    @ManyToMany
    private Set<Zanr> zanr = new HashSet<Zanr>();

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "id=" + id +
                ", naslov='" + naslov + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", objavljena='" + objavljena + '\'' +
                ", brojStrana=" + brojStrana +
                ", ocena=" + ocena +
                ", autor=" + autor.getIme() +
                '}';
    }
}
