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
//        if (knjigaService.findOne(idKnjige) == null) {
//            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
//        }
//
//        if (policaService.findOne(idPolice) == null) {
//            return new ResponseEntity<>("Ne postoji polica", HttpStatus.BAD_REQUEST);
//        }
//
//        Boolean njegova = false;
//        Boolean naPrimarnoj = false;
//        for (Polica p : korisnikService.findOne(korisnik.getId()).getPolice()) {
//            if (p.getPrimarna()) {
//                for (Stavka stavka : p.getStavke()) {
//                    if (stavka.getKnjiga().getId().equals(idKnjige)) {
//                        naPrimarnoj = true;
//                        break;
//                    }
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
//        if (!policaService.findOne(idPolice).getPrimarna() && !naPrimarnoj) {
//            return new ResponseEntity<>("Morate prvo dodati knjigu na primarnu policu", HttpStatus.BAD_REQUEST);
//        }
//
//        if (naPrimarnoj) {
//            for (Polica p : korisnikService.findOne(korisnik.getId()).getPolice()) {
//                if (p.getPrimarna()) {
//                    for (Stavka stavka : p.getStavke()) {
//                        if (stavka.getKnjiga().getId().equals(idKnjige)) {
//
//                        }
//                    }
//                }
//            }
//        }
//
//        knjigaPolicaService.dodaj(korisnik.getId(), idKnjige, idPolice);

        return ResponseEntity.ok("Uspesno dodana knjiga na policu");
    }
}
