package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Polica;
import web.projekat.entity.Stavka;
import web.projekat.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KnjigaPolicaController {
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private PolicaService policaService;
    @Autowired
    private KnjigaPolicaService knjigaPolicaService;
    @Autowired
    private StavkaService stavkaService;

    @PutMapping("/api/knjiga/{idKnjige}/polica/{idPolice}")
    public ResponseEntity<String> dodaj(@PathVariable Long idKnjige, @PathVariable Long idPolice, HttpSession session) {
//        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
//
//        if (korisnik == null) {
//            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
//        }
//
//        korisnik = korisnikService.findOne(korisnik.getId());
//        Knjiga knjiga = knjigaService.findOne(idKnjige);
//
//        if (knjiga == null) {
//            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
//        }
//
//        Polica polica = policaService.findOne(idPolice);
//
//        if (polica == null) {
//            return new ResponseEntity<>("Ne postoji polica", HttpStatus.BAD_REQUEST);
//        }
//
//        List<Polica> police = new ArrayList<>();
//        Boolean njegova = false;
//        for (Polica p : korisnikService.findOne(korisnik.getId()).getPolice()) {
//            for (Stavka stavka : p.getStavke()) {
//                if (stavka.getKnjiga().getId().equals(idKnjige)) {
//                    police.add(p);
//                    break;
//                }
//            }
//            if (p.getId().equals(idPolice)) {
//                njegova = true;
//            }
//        }
//
//        if (!njegova) {
//            return new ResponseEntity<>("Nije vasa polica", HttpStatus.BAD_REQUEST);
//        }
//
//        Boolean naPrimarnoj = false;
//        for (Polica p : police)
//            if (p.getPrimarna())
//                naPrimarnoj = true;
//
//        if (!policaService.findOne(idPolice).getPrimarna() && !naPrimarnoj) {
//            return new ResponseEntity<>("Morate prvo dodati knjigu na primarnu policu", HttpStatus.BAD_REQUEST);
//        }
//
//        if (naPrimarnoj) {
//            Stavka stavka;
//            for (Polica p : police) {
//                if (p.getPrimarna()) {
//                    for (Stavka s : p.getStavke()) {
//                        if (s.getKnjiga().getId().equals(idKnjige))
//                            stavka = s;
//                    }
//                }
//            }
//
//        }
//
//        knjigaPolicaService.dodaj(korisnik.getId(), idKnjige, idPolice);

        return ResponseEntity.ok("Uspesno dodana knjiga na policu");
    }
}
