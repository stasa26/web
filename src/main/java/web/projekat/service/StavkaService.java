package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.StavkaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Stavka;
import web.projekat.repository.KnjigaRepository;
import web.projekat.repository.StavkaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StavkaService {
    @Autowired
    private StavkaRepository stavkaRepository;

    public Stavka findOne(Long id) {
        Optional<Stavka> stavka = stavkaRepository.findById(id);
        if (stavka.isPresent())
            return stavka.get();
        return null;
    }

    public List<Stavka> findAll() {
        return stavkaRepository.findAll();
    }

    public void save(StavkaDto dto) {
        Stavka stavka = new Stavka();
        stavka.setRecenzija(dto.getRecenzija());
        stavka.setKnjiga(dto.getKnjiga());
        stavka.setPolica(dto.getPolica());
        stavkaRepository.save(stavka);
    }
}
