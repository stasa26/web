package web.projekat.dto;

import jakarta.persistence.OneToOne;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Polica;
import web.projekat.entity.Recenzija;
import web.projekat.entity.Stavka;

public class StavkaDto {
    private Long id;
    private Recenzija recenzija;
    private Knjiga knjiga;
    private Polica polica;

    public StavkaDto(){}
    public StavkaDto(Long id,Recenzija recenzija,Knjiga knjiga,Polica polica){
        this.id = id;
        this.knjiga = knjiga;
        this.recenzija = recenzija;
        this.polica = polica;
    }
    public StavkaDto(Stavka stavka){
        this.id = stavka.getId();
        this.recenzija = stavka.getRecenzija();
        this.knjiga = stavka.getKnjiga();
        this.polica = stavka.getPolica();
    }

    public Long getId() {
        return id;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public Polica getPolica() {
        return polica;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public void setPolica(Polica polica) {
        this.polica = polica;
    }
}
