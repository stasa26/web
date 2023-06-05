package web.projekat.dto;

public class KorisnikDto {
    private String email;
    private String password;

    public KorisnikDto(){
    }
    public KorisnikDto(String email,String password){
        this.email = email;
        this.password = password;
    }
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
