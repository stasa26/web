package web.projekat.dto;

public class RegistracijaDto {
    private String Ime;
    private String Prezime;
    private String email;
    private String password;

    public RegistracijaDto() {};
    public RegistracijaDto(String Ime,String Prezime,String email,String password){
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.email = email;
        this.password = password;
    }

    public String getIme(){return Ime;}
    public void setIme(String Ime){this.Ime = Ime;}
    public String getPrezime(){return Prezime;}
    public void setPrezime(String Prezime){this.Prezime = Prezime;}
    public String getEmail(){return email;}
    public void setEmail(String Email){this.email = email;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}
}
