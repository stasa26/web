package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Polica;
import web.projekat.entity.Stavka;
import web.projekat.repository.KnjigaRepository;
import web.projekat.repository.KorisnikRepository;
import web.projekat.repository.PolicaRepository;
import web.projekat.repository.StavkaRepository;

@Service
public class KnjigaPolicaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private PolicaRepository policaRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private StavkaRepository stavkaRepository;

    public void dodaj(Long idKorisnika, Long idKnjige, Long idPolice) {
//        Korisnik korisnik = korisnikRepository.findById(idKorisnika).get();
//        Knjiga knjiga = knjigaRepository.findById(idKnjige).get();
//        Polica polica = policaRepository.findById(idPolice).get();
//
//        Stavka stavka = new Stavka();
//        stavka.setKnjiga(knjiga);
//        stavka.setPolica(polica);
//        stavka.setRecenzija(null);
//        for (Polica p : korisnik.getPolice()) {
//            if (p.getId().equals(idPolice)) {
//
//            }
//        }
    }
}
