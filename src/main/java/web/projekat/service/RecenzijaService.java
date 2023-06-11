package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.RecenzijaDto;
import web.projekat.dto.RegistracijaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Recenzija;
import web.projekat.repository.KnjigaRepository;
import web.projekat.repository.RecenzijaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
    @Autowired
    private KorisnikService korisnikService;

    public Recenzija findOne(Long id) {
        Optional<Recenzija> recenzija = recenzijaRepository.findById(id);
        if (recenzija.isPresent())
            return recenzija.get();
        return null;
    }

    public List<Recenzija> findAll() {return recenzijaRepository.findAll();
    }

    public void save(RecenzijaDto dto) {
        Recenzija recenzija = new Recenzija();
        recenzija.setOcena(dto.getOcena());
        recenzija.setDatum(dto.getDatum());
        recenzija.setTekst(dto.getTekst());
        recenzijaRepository.save(recenzija);
    }
}
