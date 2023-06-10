package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.entity.Knjiga;
import web.projekat.repository.KnjigaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;

    public Knjiga findOne(Long id) {
        Optional<Knjiga> knjiga = knjigaRepository.findById(id);
        if (knjiga.isPresent())
            return knjiga.get();
        return null;
    }

    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    public void save(KnjigaDto dto) {
        Knjiga knjiga = new Knjiga();
        knjiga.setISBN(dto.getISBN());
        knjiga.setNaslov(dto.getNaslov());
        knjiga.setObjavljena(dto.getObjavljena());
        knjiga.setBrojStrana(dto.getBrojStrana());
        knjiga.setOpis(dto.getOpis());
        knjigaRepository.save(knjiga);
    }
}
