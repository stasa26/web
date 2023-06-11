package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.PolicaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Polica;
import web.projekat.repository.KnjigaRepository;
import web.projekat.repository.PolicaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;

    public Polica findOne(Long id) {
        Optional<Polica> polica = policaRepository.findById(id);
        if (polica.isPresent())
            return polica.get();
        return null;
    }

    public List<Polica> findAll() {
        return policaRepository.findAll();
    }

    public void save(PolicaDto dto) {
        Polica polica = new Polica();
        polica.setNaziv(dto.getNaziv());
        polica.setPrimarna(dto.getPrimarna());
        policaRepository.save(polica);
    }
}
