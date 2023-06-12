package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.RecenzijaDto;
import web.projekat.entity.*;
import web.projekat.service.KnjigaService;
import web.projekat.service.KorisnikService;
import web.projekat.service.RecenzijaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RecenzijaController {
    @Autowired
    private RecenzijaService recenzijaService;
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("recenzija/{id}")
    public ResponseEntity<RecenzijaDto> getRecenzija(@PathVariable Long id) {
        Recenzija recenzija = recenzijaService.findOne(id);
        if (recenzija == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new RecenzijaDto(recenzija));
    }

    @GetMapping("recenzije")
    public ResponseEntity<List<RecenzijaDto>> getRecenzije() {
        List<Recenzija> recenzije = recenzijaService.findAll();
        List<RecenzijaDto> dtos = new ArrayList<>();
        for (Recenzija recenzija : recenzije)
            dtos.add(new RecenzijaDto(recenzija));
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("recenzija/knjiga/{idKnjige}")
    public ResponseEntity<String> dodajRecenziju(@RequestBody RecenzijaDto dto, @PathVariable Long idKnjige, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        dto.setKorisnik(korisnik.getId());
        Recenzija recenzija = recenzijaService.save(dto);

        for (Polica p : korisnikService.findOne(korisnik.getId()).getPolice())
            for (Stavka stavka : p.getStavke())
                if (stavka.getKnjiga().getId().equals(idKnjige))
                    stavka.setRecenzija(recenzija);

        korisnikService.save(korisnik);
        return ResponseEntity.ok("Uspesno dodano");
    }

    @PutMapping("recenzija/{id}")
    public ResponseEntity<String> izmeniRecenziju(@PathVariable Long id, @RequestBody RecenzijaDto recenzijaDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);
        }

        Recenzija recenzija = recenzijaService.findOne(id);

        if (recenzija == null) {
            return new ResponseEntity<>("Ne postoji recenzija", HttpStatus.BAD_REQUEST);
        }

        if (!recenzija.getKorisnik().getId().equals(korisnik.getId())) {
            return new ResponseEntity<>("Nije vasa recenzija", HttpStatus.FORBIDDEN);
        }

        recenzijaService.edit(recenzija, recenzijaDto);
        return ResponseEntity.ok("Uspesno izmenjena");
    }

    @DeleteMapping("recenzija/{id}")
    public ResponseEntity<String> obrisiRecenziju(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        recenzijaService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }
}
