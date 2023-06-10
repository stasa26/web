package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.projekat.dto.RegistracijaDto;
import web.projekat.entity.Korisnik;
import web.projekat.repository.KorisnikRepository;

import java.util.List;
import java.util.Optional;
@Component
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }
    public Korisnik findOne(Long id) {
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;

    }
    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
    public Korisnik login(String email, String password) {

        Korisnik korisnik = korisnikRepository.getByEmail(email);
        if(korisnik == null || !korisnik.getPassword().equals(password))
            return null;
        return  korisnik;

    }

    public void register(RegistracijaDto dto) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(dto.getIme());
        korisnik.setPrezime(dto.getPrezime());
        korisnik.setEmail(dto.getEmail());
        korisnik.setPassword(dto.getPassword());
        save(korisnik);
    }
}
