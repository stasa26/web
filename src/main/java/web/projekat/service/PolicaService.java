package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.PolicaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Polica;
import web.projekat.entity.Stavka;
import web.projekat.repository.KnjigaRepository;
import web.projekat.repository.PolicaRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
    @Autowired
    private StavkaService stavkaService;

    public Polica findOne(Long id) {
        Optional<Polica> polica = policaRepository.findById(id);
        if (polica.isPresent())
            return polica.get();
        return null;
    }

    public List<Polica> findAll() {
        return policaRepository.findAll();
    }

    public Polica save(PolicaDto dto) {
        Polica polica = new Polica();
        polica.setNaziv(dto.getNaziv());
        polica.setPrimarna(dto.getPrimarna());
        return policaRepository.save(polica);
    }

    public Set<Polica> napraviPrimarne(Korisnik korisnik) {
        Set<Polica> police = new HashSet<>();
        police.add(save(new PolicaDto(null, "Read", true, korisnik.getId())));
        police.add(save(new PolicaDto(null, "Want To Read", true, korisnik.getId())));
        police.add(save(new PolicaDto(null, "Currently Reading", true, korisnik.getId())));
        return police;
    }
    public void delete(Polica polica) {
        policaRepository.delete(polica);
    }
}
