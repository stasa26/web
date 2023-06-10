package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.KorisnikDto;
import web.projekat.dto.LoginDto;
import web.projekat.dto.RegisterDto;
import web.projekat.entity.Korisnik;
import web.projekat.service.KorisnikService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class KorisnikController {

    private final KorisnikService korisnikService;
    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
            return new ResponseEntity("Email ili lozinka nisu tacni", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getEmail(), loginDto.getPassword());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("Korisnik ne postoji!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");
    }

    @RequestMapping("logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }
    @GetMapping("korisnik")
    public ResponseEntity<List<KorisnikDto>> getKorisnik(HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("employee");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("korisnik/{id}")
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable(name = "id") Long id){
        Korisnik korisnik = korisnikService.findOne(id);

        if (korisnik == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        KorisnikDto dto = new KorisnikDto(korisnik);

        return ResponseEntity.ok(dto);
    }
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto dto) {
        if (!dto.getPassword().equals(dto.getPasswordPonovo()))
            return new ResponseEntity<>("Lozinka se ne poklapa", HttpStatus.BAD_REQUEST);
        korisnikService.register(dto);
        return ResponseEntity.ok("Registrovan");
    }


}
