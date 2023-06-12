package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.RecenzijaDto;
import web.projekat.entity.*;
import web.projekat.service.KnjigaService;
import web.projekat.service.KorisnikService;
import web.projekat.service.RecenzijaService;
import web.projekat.service.StavkaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;
    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private StavkaService stavkaService;

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

        if (korisnik.getUloga().equals(Uloga.CITALAC))
            return new ResponseEntity<>("Morate biti autor ili administrator", HttpStatus.FORBIDDEN);

        knjigaService.save((Autor)korisnikService.findOne(korisnik.getId()), dto);
        return ResponseEntity.ok("Uspesno dodano");
    }

    @PutMapping("knjiga/{id}")
    public ResponseEntity<String> azurirajKnjigu(@PathVariable Long id, @RequestBody KnjigaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (korisnik.getUloga().equals(Uloga.CITALAC))
            return new ResponseEntity<>("Morate biti autor ili administrator", HttpStatus.FORBIDDEN);

        if (knjigaService.findOne(id) == null) {
            return new ResponseEntity<>("Ne postoji knjiga", HttpStatus.BAD_REQUEST);
        }

        knjigaService.edit(id, dto);
        return ResponseEntity.ok("Uspesno azurirano");
    }

    @DeleteMapping("knjiga/{id}")
    public ResponseEntity<String> obrisiKnjigu(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (korisnik.getUloga().equals(Uloga.CITALAC)) {
            return new ResponseEntity<>("Morate biti autor knjige ili admin", HttpStatus.FORBIDDEN);
        }

        if (korisnik.getUloga().equals(Uloga.AUTOR) && !knjigaService.findOne(id).getAutor().getId().equals(korisnik.getId())) {
            return new ResponseEntity<>("Nije vasa knjiga", HttpStatus.FORBIDDEN);
        }

        for (Stavka stavka : stavkaService.findAllByKnjigaId(id))
            if (stavka.getRecenzija() != null)
                return new ResponseEntity<>("Ne moze se obrisati knjiga sa recenzijama", HttpStatus.BAD_REQUEST);

        knjigaService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }

    @GetMapping("knjiga/pretrazi")
    public ResponseEntity<List<KnjigaDto>> pretraga(@RequestParam String pretraga) {
        // Pronalazi sve knjige sa tim nazivom i knjige ciji se autor zove ili preziva tako
        List<Knjiga> knjige = knjigaService.findAllByNaziv(pretraga);

        Autor autor = korisnikService.findAutorByIme(pretraga);
        if (autor != null) {
            knjige.addAll(knjigaService.findAllByAutorId(autor.getId()));
        }

        autor = korisnikService.findAutorByPrezime(pretraga);
        if (autor != null) {
            knjige.addAll(knjigaService.findAllByAutorId(autor.getId()));
        }

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga knjiga : knjige)
            dtos.add(new KnjigaDto(knjiga));
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("knjiga/{id}/recenzije")
    public ResponseEntity<List<RecenzijaDto>> recenzijeKnjige(@PathVariable Long id) {
        Knjiga knjiga = knjigaService.findOne(id);

        if (knjiga == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<RecenzijaDto> recenzije = new ArrayList<>();
        for (Stavka stavka : stavkaService.findAllByKnjigaId(id))
            if (stavka.getRecenzija() != null)
                recenzije.add(new RecenzijaDto(stavka.getRecenzija()));

        return ResponseEntity.ok(recenzije);
    }
}
