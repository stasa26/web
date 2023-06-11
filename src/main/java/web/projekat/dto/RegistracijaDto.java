package web.projekat.dto;

public class RegistracijaDto {
    private String Ime;
    private String Prezime;
    private String korisnickoIme;
    private String email;
    private String password;
    private String passwordPonovo;

    public RegistracijaDto() {};
    public RegistracijaDto(String Ime, String Prezime, String korisnickoIme, String email, String password, String passwordPonovo){
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.password = password;
        this.passwordPonovo = passwordPonovo;
    }
    public RegistracijaDto(RegistracijaDto registracija){
        this.Ime = registracija.getIme();
        this.Prezime = registracija.getPrezime();
        this.email = registracija.getEmail();
        this.password = registracija.getPassword();
    }

    public String getIme(){return Ime;}
    public void setIme(String Ime){this.Ime = Ime;}
    public String getPrezime(){return Prezime;}
    public void setPrezime(String Prezime){this.Prezime = Prezime;}
    public String getEmail(){return email;}
    public void setEmail(String Email){this.email = email;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getPasswordPonovo() {
        return passwordPonovo;
    }

    public void setPasswordPonovo(String passwordPonovo) {
        this.passwordPonovo = passwordPonovo;
    }
}
