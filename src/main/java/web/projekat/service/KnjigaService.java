package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.KnjigaDto;
import web.projekat.entity.Autor;
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

    public List<Knjiga> findAllByNaziv(String naziv) {
        return knjigaRepository.findAllByNaslov(naziv);
    }

    public List<Knjiga> findAllByAutorId(Long autorId) {
        return knjigaRepository.findAllByAutorId(autorId);
    }

    public void save(Autor autor, KnjigaDto dto) {
        Knjiga knjiga = new Knjiga();
        knjiga.setISBN(dto.getISBN());
        knjiga.setNaslov(dto.getNaslov());
        knjiga.setObjavljena(dto.getObjavljena());
        knjiga.setBrojStrana(dto.getBrojStrana());
        knjiga.setOpis(dto.getOpis());
        knjiga.setAutor(autor);
        knjigaRepository.save(knjiga);
    }

    public void edit(Long id, KnjigaDto knjigaDto) {
        Knjiga knjiga = findOne(id);
        if (knjigaDto.getBrojStrana() != null)
            knjiga.setBrojStrana(knjigaDto.getBrojStrana());

        if (knjigaDto.getISBN() != null)
            knjiga.setISBN(knjigaDto.getISBN());

        if (knjigaDto.getNaslov() != null)
            knjiga.setNaslov(knjigaDto.getNaslov());

        if (knjigaDto.getOpis() != null)
            knjiga.setOpis(knjigaDto.getOpis());

        if (knjigaDto.getObjavljena() != null)
            knjiga.setObjavljena(knjigaDto.getObjavljena());

        knjigaRepository.save(knjiga);
    }

    public void delete(Long id) {
        knjigaRepository.deleteById(id);
    }
}
