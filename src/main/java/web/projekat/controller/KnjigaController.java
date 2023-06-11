package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KnjigaDto;
import web.projekat.entity.Autor;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Uloga;
import web.projekat.service.KnjigaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("knjiga/{id}")
    public ResponseEntity<KnjigaDto> getKnjiga(@PathVariable Long id) {
        Knjiga knjiga = knjigaService.findOne(id);
        if (knjiga == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new KnjigaDto(knjiga));
    }

    @GetMapping("knjige")
    public ResponseEntity<List<KnjigaDto>> getKnjige() {
        List<Knjiga> knjige = knjigaService.findAll();
        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga knjiga : knjige)
            dtos.add(new KnjigaDto(knjiga));
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("knjiga")
    public ResponseEntity<String> dodajKnjigu(@RequestBody KnjigaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (!korisnik.getUloga().equals(Uloga.AUTOR))
            return new ResponseEntity<>("Morate biti autor", HttpStatus.FORBIDDEN);

        knjigaService.save((Autor)korisnik, dto);
        return ResponseEntity.ok("Uspesno dodano");
    }

    @DeleteMapping("knjiga/{id}")
    public ResponseEntity<String> obrisiKnjigu(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        knjigaService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }
}
