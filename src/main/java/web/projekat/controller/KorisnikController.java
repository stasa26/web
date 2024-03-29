package web.projekat.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.projekat.dto.KorisnikDto;
import web.projekat.dto.LoginDto;
import web.projekat.dto.RegistracijaDto;
import web.projekat.dto.ZahtevZaPrihvatanjeAutoraDto;
import web.projekat.entity.Autor;
import web.projekat.entity.Korisnik;
import web.projekat.entity.Uloga;
import web.projekat.service.KorisnikService;
import web.projekat.service.ZahtevZaPrihvatanjeAutoraService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class KorisnikController {

    private final KorisnikService korisnikService;
    @Autowired
    private ZahtevZaPrihvatanjeAutoraService zahtevZaPrihvatanjeAutoraService;
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
    @GetMapping("korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
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
    public ResponseEntity<String> register(@RequestBody RegistracijaDto dto) {
        if (!dto.getPasswordPonovo().equals(dto.getPassword()))
            return new ResponseEntity<>("Password se ne poklapa", HttpStatus.BAD_REQUEST);

        if (korisnikService.findByKorisnickoIme(dto.getKorisnickoIme()) != null)
            return new ResponseEntity<>("Vec postoji to korisnicko ime", HttpStatus.BAD_REQUEST);

        if (korisnikService.findByEmail(dto.getEmail()) != null)
            return new ResponseEntity<>("Vec postoji taj email", HttpStatus.BAD_REQUEST);

        korisnikService.register(dto);
        return ResponseEntity.ok("Registrovan");
    }

    @PostMapping("autor")
    public ResponseEntity<String> napraviAutora(@RequestBody RegistracijaDto dto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (!korisnik.getAdmin())
            return new ResponseEntity<>("Morate biti admin", HttpStatus.FORBIDDEN);

        if (korisnikService.findByKorisnickoIme(dto.getKorisnickoIme()) != null)
            return new ResponseEntity<>("Vec postoji to korisnicko ime", HttpStatus.BAD_REQUEST);

        if (korisnikService.findByEmail(dto.getEmail()) != null)
            return new ResponseEntity<>("Vec postoji taj email", HttpStatus.BAD_REQUEST);

        korisnikService.napraviAutora(dto);
        return ResponseEntity.ok("Uspesno dodan");
    }
    @DeleteMapping("korisnik/{id}")
    public ResponseEntity<String> obrisiKorisnika(@PathVariable Long id, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null)
            return new ResponseEntity<>("Forbidden", HttpStatus.FORBIDDEN);

        if (!korisnik.getUloga().equals(Uloga.ADMINISTRATOR) && !korisnik.getId().equals(id)) {
            return new ResponseEntity<>("Mozete samo sami sebe obrisati", HttpStatus.FORBIDDEN);
        }

        korisnikService.delete(id);
        return ResponseEntity.ok("Uspesno obrisano");
    }

    @PutMapping("korisnik/{id}")
    public ResponseEntity<String> podnesiZahtev(@PathVariable Long id, @RequestBody ZahtevZaPrihvatanjeAutoraDto zahtevDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik != null) {
            return new ResponseEntity<>("Morate biti odjaljeni da bi podneli zahtev", HttpStatus.FORBIDDEN);
        }

        if (zahtevDto.getEmail() == null || zahtevDto.getPoruka() == null || zahtevDto.getTelefon() == null || zahtevDto.getIdAutora() == null) {
            return new ResponseEntity<>("Moraju svi podaci biti popunjeni", HttpStatus.BAD_REQUEST);
        }

        Korisnik autor = korisnikService.findOne(id);

        if (autor == null) {
            return new ResponseEntity<>("Ne postoji taj autor", HttpStatus.BAD_REQUEST);
        }

        if (!autor.getUloga().equals(Uloga.AUTOR)) {
            return new ResponseEntity<>("Ovaj korisnik nije autor", HttpStatus.BAD_REQUEST);
        }

        zahtevZaPrihvatanjeAutoraService.save(zahtevDto, (Autor)autor);
        return ResponseEntity.ok("Uspesno podnet zahtev");
    }

    @PutMapping("korisnik")
    public ResponseEntity<String> azurirajProfil(@RequestBody KorisnikDto korisnikDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (korisnikDto.getPassword() != null && !korisnikDto.getTrenutniPassword().equals(korisnikService.findOne(korisnik.getId()).getPassword())) {
            return new ResponseEntity<>("Pogresan password", HttpStatus.FORBIDDEN);
        }

        if (korisnikDto.getEmail() != null && !korisnikDto.getTrenutniPassword().equals(korisnikService.findOne(korisnik.getId()).getPassword())) {
            return new ResponseEntity<>("Pogresan password", HttpStatus.FORBIDDEN);
        }

        korisnikService.azurirajProfil(korisnik.getId(), korisnikDto);
        return ResponseEntity.ok("Uspesno azuriran");
    }

    @PutMapping("autor/{id}")
    public ResponseEntity<String> azurirajAutora(@PathVariable Long id, @RequestBody KorisnikDto korisnikDto, HttpSession session) {
        Korisnik korisnik = (Korisnik) session.getAttribute("korisnik");

        if (korisnik == null) {
            return new ResponseEntity<>("Niste prijavljeni", HttpStatus.FORBIDDEN);
        }

        if (!korisnik.getAdmin()) {
            return new ResponseEntity<>("Niste admin", HttpStatus.FORBIDDEN);
        }

        korisnikService.azurirajProfil(id, korisnikDto);
        return ResponseEntity.ok("Uspesno azuriran autor");
    }
}
