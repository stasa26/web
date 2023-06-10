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
import web.projekat.entity.Korisnik;
import web.projekat.service.KorisnikService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class KorisnikController {

    private final KorisnikService korisnikService;
    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public List<Korisnik> getKorisnik(){
        return korisnikService.getKorisnik();
    }
    @PostMapping("api/login")
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
    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }
    @GetMapping("/api/korisnik")
    public ResponseEntity<List<KorisnikDto>> getKorisnik(HttpSession session){
        List<Korisnik> employeeList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("employee");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        Korisnik[] korisnikList;
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/api/korisnik/{id}")
    public Korisnik getKorisnik(@PathVariable(name = "id") Long id, HttpSession session){
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");
        System.out.println(korisnik.getEmail());
        session.invalidate();
        return korisnikService.findOne(id);
    }
    @PostMapping("/api/save-korisnik")
    public String saveKorisnik(@RequestBody Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "Successfully saved an employee!";
    }


}
