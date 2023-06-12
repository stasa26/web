package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.projekat.controller.PolicaController;
import web.projekat.dto.KorisnikDto;
import web.projekat.dto.RegistracijaDto;
import web.projekat.entity.Autor;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Uloga;
import web.projekat.repository.AutorRepository;
import web.projekat.repository.KorisnikRepository;

import java.util.List;
import java.util.Optional;
@Component
@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private PolicaService policaService;

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }
    public Korisnik findOne(Long id) {
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;

    }

    public Korisnik findByEmail(String email) {
        Optional<Korisnik> korisnik = korisnikRepository.findByEmail(email);
        if (korisnik.isPresent())
            return korisnik.get();
        return null;
    }

    public Korisnik findByKorisnickoIme(String korisnickoIme) {
        Optional<Korisnik> korisnik = korisnikRepository.findByKorisnickoIme(korisnickoIme);
        if (korisnik.isPresent())
            return korisnik.get();
        return null;
    }
    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }
    public Korisnik login(String email, String password) {

        Optional<Korisnik> korisnik = korisnikRepository.findByEmail(email);
        if(korisnik.isEmpty())
            return null;

        if (!korisnik.get().getPassword().equals(password))
            return null;

        return  korisnik.get();

    }

    public void register(RegistracijaDto dto) {
        // Ne radi email?
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(dto.getIme());
        korisnik.setPrezime(dto.getPrezime());
        korisnik.setEmail(dto.getEmail());
        korisnik.setPassword(dto.getPassword());
        korisnik.setKorisnickoIme(dto.getKorisnickoIme());
        korisnik.setAdmin(false);
        korisnik.setUloga(Uloga.CITALAC);
        korisnik.setPolice(policaService.napraviPrimarne(korisnik));
        save(korisnik);
    }

    public void napraviAutora(RegistracijaDto dto) {
        Autor autor = new Autor();
        autor.setAktivan(false);
        autor.setIme(dto.getIme());
        autor.setPrezime(dto.getPrezime());
        autor.setKorisnickoIme(dto.getKorisnickoIme());
        autor.setEmail(dto.getEmail());
        autor.setPassword(dto.getPassword());
        autorRepository.save(autor);
    }
    public void delete(Long id) {
        korisnikRepository.deleteById(id);
    }

    public Autor findAutorByIme(String ime) {
        Optional<Autor> autor = autorRepository.findByIme(ime);
        if (autor.isPresent())
            return autor.get();
        return null;
    }

    public Autor findAutorByPrezime(String prezime) {
        Optional<Autor> autor = autorRepository.findByPrezime(prezime);
        if (autor.isPresent())
            return autor.get();
        return null;
    }

    public void azurirajProfil(Long id, KorisnikDto korisnikDto) {
        Korisnik korisnik = findOne(id);
        if (korisnikDto.getDatumRodjenja() != null)
            korisnik.setDatumRodjenja(korisnikDto.getDatumRodjenja());

        if (korisnikDto.getIme() != null)
            korisnik.setIme(korisnikDto.getIme());

        if (korisnikDto.getPrezime() != null)
            korisnik.setPrezime(korisnikDto.getPrezime());

        if (korisnikDto.getOpis() != null)
            korisnik.setOpis(korisnikDto.getOpis());

        if (korisnikDto.getPassword() != null)
            korisnik.setPassword(korisnikDto.getPassword());

        if (korisnikDto.getEmail() != null)
            korisnik.setEmail(korisnikDto.getEmail());

        korisnikRepository.save(korisnik);
    }
}
