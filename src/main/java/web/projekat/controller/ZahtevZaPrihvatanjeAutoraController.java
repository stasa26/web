package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.ZahtevZaPrihvatanjeAutoraDto;
import web.projekat.dto.ZanrDto;
import web.projekat.entity.Korisnik;
import web.projekat.entity.ZahtevZaPrihvatanjeAutora;
import web.projekat.service.ZahtevZaPrihvatanjeAutoraService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ZahtevZaPrihvatanjeAutoraController {
    @Autowired
    private ZahtevZaPrihvatanjeAutoraService zahtevZaPrihvatanjeAutoraService;

    @GetMapping("zahtev/{id}")
    public ResponseEntity<ZahtevZaPrihvatanjeAutoraDto> jedanZahtev(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

        if (!korisnik.getAdmin())
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

        return ResponseEntity.ok(new ZahtevZaPrihvatanjeAutoraDto(zahtevZaPrihvatanjeAutoraService.findOne(id)));
    }

    @GetMapping("zahtevi")
    public ResponseEntity<List<ZahtevZaPrihvatanjeAutoraDto>> sviZahtevi(HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

        if (!korisnik.getAdmin())
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);

        List<ZahtevZaPrihvatanjeAutora> zahtevi = zahtevZaPrihvatanjeAutoraService.findAll();
        List<ZahtevZaPrihvatanjeAutoraDto> dtos = new ArrayList<>();
        for (ZahtevZaPrihvatanjeAutora zahtev : zahtevi)
            dtos.add(new ZahtevZaPrihvatanjeAutoraDto(zahtev));

        return ResponseEntity.ok(dtos);
    }
    @DeleteMapping("zahtev/{id}")
    public ResponseEntity<String> obrisiZahtev(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        zahtevZaPrihvatanjeAutoraService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }
}
