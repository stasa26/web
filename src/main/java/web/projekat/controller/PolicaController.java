package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.PolicaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Polica;
import web.projekat.service.KnjigaService;
import web.projekat.service.PolicaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PolicaController {
    @Autowired
    private PolicaService policaService;

    @GetMapping("polica/{id}")
    public ResponseEntity<PolicaDto> getPolica(@PathVariable Long id) {
        Polica polica = policaService.findOne(id);
        if (polica == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new PolicaDto(polica));
    }

    @GetMapping("police")
    public ResponseEntity<List<PolicaDto>> getPolice() {
        List<Polica> police= policaService.findAll();
        List<PolicaDto> dtos = new ArrayList<>();
        for (Polica polica : police)
            dtos.add(new PolicaDto(polica));
        return ResponseEntity.ok(dtos);
    }

    @PostMapping("polica")
    public ResponseEntity<String> dodajPolicu(@RequestBody PolicaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        dto.setPrimarna(false);
        dto.setKorisnik(korisnik.getId());
        policaService.save(dto);
        return ResponseEntity.ok("Uspesno dodano");
    }
}
