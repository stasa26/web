package web.projekat.dto;

import web.projekat.entity.Korisnik;

public class KorisnikDto {
    private Long id;
    private String email;
    private String password;

    public KorisnikDto(){
    }
    public KorisnikDto(Long id,String email,String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }
    public KorisnikDto(Korisnik korisnik){
        this.id = korisnik.getId();
        this.email = korisnik.getEmail();
        this.password = korisnik.getPassword();
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
}
