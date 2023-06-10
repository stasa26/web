package web.projekat.dto;

public class RegisterDto {
    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String password;
    private String passwordPonovo;

    public RegisterDto(String ime, String prezime, String email, String korisnickoIme, String password, String passwordPonovo) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.korisnickoIme = korisnickoIme;
        this.password = password;
        this.passwordPonovo = passwordPonovo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordPonovo() {
        return passwordPonovo;
    }

    public void setPasswordPonovo(String passwordPonovo) {
        this.passwordPonovo = passwordPonovo;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
}
