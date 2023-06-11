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
import web.projekat.entity.Zanr;
import web.projekat.service.ZanrService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ZanrController {
    @Autowired
    private ZanrService zanrService;
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
}
