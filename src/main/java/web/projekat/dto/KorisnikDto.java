package web.projekat.dto;

import web.projekat.entity.Korisnik;

import java.util.Date;

public class KorisnikDto {
    private Long id;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String password;
    private String trenutniPassword;
    private String opis;
    private Date datumRodjenja;

    public KorisnikDto(){
    }

    public KorisnikDto(Long id, String ime, String prezime, String korisnickoIme, String email, String password, String trenutniPassword, String opis, Date datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.password = password;
        this.trenutniPassword = trenutniPassword;
        this.opis = opis;
        this.datumRodjenja = datumRodjenja;
    }

    public KorisnikDto(Korisnik korisnik){
        this.id = korisnik.getId();
//        this.email = korisnik.getEmail();
//        this.password = korisnik.getPassword();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.korisnickoIme = korisnik.getKorisnickoIme();
        this.opis = korisnik.getOpis();
        this.datumRodjenja = korisnik.getDatumRodjenja();
    }
    public Long getId(){ return id;}
    public void setId(Long id){this.id = id;}
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTrenutniPassword() {
        return trenutniPassword;
    }

    public void setTrenutniPassword(String trenutniPassword) {
        this.trenutniPassword = trenutniPassword;
    }
}
