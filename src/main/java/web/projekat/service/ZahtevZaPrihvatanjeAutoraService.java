package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.dto.ZahtevZaPrihvatanjeAutoraDto;
import web.projekat.entity.Autor;
import web.projekat.entity.Status;
import web.projekat.entity.ZahtevZaPrihvatanjeAutora;
import web.projekat.repository.ZahtevZaPrihvatanjeAutoraRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ZahtevZaPrihvatanjeAutoraService {
    @Autowired
    private ZahtevZaPrihvatanjeAutoraRepository zahtevZaPrihvatanjeAutoraRepository;

    public ZahtevZaPrihvatanjeAutora findOne(Long id) {
        Optional<ZahtevZaPrihvatanjeAutora> zahtev = zahtevZaPrihvatanjeAutoraRepository.findById(id);
        if (zahtev.isPresent())
            return zahtev.get();
        return null;
    }

    public List<ZahtevZaPrihvatanjeAutora> findAll() {
        return zahtevZaPrihvatanjeAutoraRepository.findAll();
    }
    public void delete(Long id) {zahtevZaPrihvatanjeAutoraRepository.deleteById(id);
    }

    public void save(ZahtevZaPrihvatanjeAutoraDto zahtevDto, Autor autor) {
        ZahtevZaPrihvatanjeAutora zahtev = new ZahtevZaPrihvatanjeAutora();
        zahtev.setAutor(autor);
        zahtev.setDatum(new Date());
        zahtev.setEmail(zahtevDto.getEmail());
        zahtev.setPoruka(zahtevDto.getPoruka());
        zahtev.setTelefon(zahtevDto.getTelefon());
        zahtev.setStatus(Status.CEKA);
        zahtevZaPrihvatanjeAutoraRepository.save(zahtev);
    }
}
