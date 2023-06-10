package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import web.projekat.dto.KorisnikDto;
import web.projekat.entity.Korisnik;
import web.projekat.repository.KorisnikRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public void save(Korisnik korisnik) {
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

    public List<Korisnik> getKorisnik() {
        return List.of(getKorisnik().get());
    }
}
