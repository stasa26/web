package web.projekat.dto;

import jakarta.persistence.OneToOne;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Polica;
import web.projekat.entity.Recenzija;
import web.projekat.entity.Stavka;

public class StavkaDto {
    private Long id;
    private Long recenzija;
    private Long knjiga;

    public StavkaDto(){}
    public StavkaDto(Long id,Long recenzija,Long knjiga){
        this.id = id;
        this.knjiga = knjiga;
        this.recenzija = recenzija;
    }
    public StavkaDto(Stavka stavka){
        this.id = stavka.getId();
        this.recenzija = stavka.getRecenzija().getId();
        this.knjiga = stavka.getKnjiga().getId();
    }

    public Long getId() {
        return id;
    }

    public Long getRecenzija() {
        return recenzija;
    }

    public Long getKnjiga() {
        return knjiga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecenzija(Long recenzija) {
        this.recenzija = recenzija;
    }

    public void setKnjiga(Long knjiga) {
        this.knjiga = knjiga;
    }
}
