package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.ZanrDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Zanr;
import web.projekat.repository.ZanrRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;
    public Zanr findOne(Long id) {
        Optional<Zanr> zanr = zanrRepository.findById(id);
        if (zanr.isPresent())
            return zanr.get();
        return null;
    }

    public Zanr findByNaziv(String naziv) {
        Optional<Zanr> zanr = zanrRepository.findByNaziv(naziv);
        if (zanr.isPresent())
            return zanr.get();
        return null;
    }

    public List<Zanr> findAll() {
        return zanrRepository.findAll();
    }

    public void save(ZanrDto dto) {
        Zanr zanr = new Zanr();
        zanr.setNaziv(dto.getNaziv());
        zanrRepository.save(zanr);
    }
    public void delete(Long id) {
        zanrRepository.deleteById(id);
    }
}
