package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.dto.KnjigaDto;
import web.projekat.entity.Knjiga;
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
}
