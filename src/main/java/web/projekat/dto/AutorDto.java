package web.projekat.dto;

import web.projekat.entity.Autor;

public class AutorDto {
    private Boolean aktivan;
    public AutorDto(){}
    public AutorDto(Boolean aktivan){
        this.aktivan = aktivan;
    }
    public AutorDto(Autor autor){
        this.aktivan = autor.getAktivan();
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }
}
