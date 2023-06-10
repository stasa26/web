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
    private Long polica;

    public StavkaDto(){}
    public StavkaDto(Long id,Long recenzija,Long knjiga,Long polica){
        this.id = id;
        this.knjiga = knjiga;
        this.recenzija = recenzija;
        this.polica = polica;
    }
    public StavkaDto(Stavka stavka){
        this.id = stavka.getId();
        this.recenzija = stavka.getRecenzija().getId();
        this.knjiga = stavka.getKnjiga().getId();
        this.polica = stavka.getPolica().getId();
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

    public Long getPolica() {
        return polica;
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

    public void setPolica(Long polica) {
        this.polica = polica;
    }
}
