package web.projekat.entity;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Autor extends Korisnik {
    private Boolean aktivan;

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "aktivan=" + aktivan +
                '}';
    }
}
