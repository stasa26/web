package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.ZanrDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Uloga;
import web.projekat.entity.Zanr;
import web.projekat.service.KnjigaService;
import web.projekat.service.ZanrService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/")
public class ZanrController {
    @Autowired
    private ZanrService zanrService;
    @Autowired
    private KnjigaService knjigaService;
    @GetMapping("zanr/{id}")
    public ResponseEntity<ZanrDto> getZanr(@PathVariable Long id) {
        Zanr zanr = zanrService.findOne(id);
        if (zanr == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ZanrDto(zanr));
    }

    @GetMapping("zanrovi")
    public ResponseEntity<List<ZanrDto>> getZanrovi() {
        List<Zanr> zanrovi = zanrService.findAll();
        List<ZanrDto> dtos = new ArrayList<>();
        for (Zanr zanr : zanrovi)
            dtos.add(new ZanrDto(zanr));
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("zanr")
    public ResponseEntity<String> dodajZanr(@RequestBody ZanrDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (!korisnik.getAdmin())
            return new ResponseEntity<>("Niste admin", HttpStatus.FORBIDDEN);

        if (zanrService.findByNaziv(dto.getNaziv()) != null)
            return new ResponseEntity<>("Vec postoji zanr", HttpStatus.BAD_REQUEST);

        zanrService.save(dto);
        return ResponseEntity.ok("Uspesno dodano");
    }
    @DeleteMapping("zanr/{id}")
    public ResponseEntity<String> obrisiZanr(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        zanrService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }

    @PutMapping("zanr/{idZanra}/knjiga/{idKnjige}")
    public ResponseEntity<String> dodajNaKnjigu(@PathVariable Long idZanra, @PathVariable Long idKnjige, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (korisnik.getUloga().equals(Uloga.CITALAC)) {
            return new ResponseEntity<>("Niste autor ili administrator", HttpStatus.FORBIDDEN);
        }

        if (zanrService.findOne(idZanra) == null) {
            return new ResponseEntity<>("Ne postoji zanr", HttpStatus.BAD_REQUEST);
        }

        if (knjigaService.findOne(idKnjige) == null) {
            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
        }

        Knjiga knjiga = knjigaService.findOne(idKnjige);

        if (korisnik.getUloga().equals(Uloga.AUTOR) && !knjiga.getAutor().getId().equals(korisnik.getId())) {
            return new ResponseEntity<>("Nije tvoja knjiga", HttpStatus.FORBIDDEN);
        }

        Set<Zanr> zanrovi = knjiga.getZanr();
        zanrovi.add(zanrService.findOne(idZanra));
        knjiga.setZanr(zanrovi);
        knjigaService.savee(knjiga);
        return ResponseEntity.ok("Uspesno dodan zanr na knjigu");
    }

    @PutMapping("zanr/{idZanra}/knjiga/{idKnjige}")
    public ResponseEntity<String> obrisiSaKnjige(@PathVariable Long idZanra, @PathVariable Long idKnjige, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (korisnik.getUloga().equals(Uloga.CITALAC)) {
            return new ResponseEntity<>("Niste autor ili administrator", HttpStatus.FORBIDDEN);
        }

        if (zanrService.findOne(idZanra) == null) {
            return new ResponseEntity<>("Ne postoji zanr", HttpStatus.BAD_REQUEST);
        }

        if (knjigaService.findOne(idKnjige) == null) {
            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
        }

        Knjiga knjiga = knjigaService.findOne(idKnjige);

        if (korisnik.getUloga().equals(Uloga.AUTOR) && !knjiga.getAutor().getId().equals(korisnik.getId())) {
            return new ResponseEntity<>("Nije tvoja knjiga", HttpStatus.FORBIDDEN);
        }

        Zanr z = null;
        for (Zanr zanr : knjiga.getZanr())
            if (zanr.getId().equals(idZanra))
                z = zanr;
        if (z != null) {
            knjiga.getZanr().remove(z);
            knjigaService.savee(knjiga);
        }
        return ResponseEntity.ok("Uspesno obrisan zanr sa knjige");
    }
}
