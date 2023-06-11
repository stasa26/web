package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.RecenzijaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Recenzija;
import web.projekat.service.KnjigaService;
import web.projekat.service.RecenzijaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class RecenzijaController {
    @Autowired
    private RecenzijaService recenzijaService;

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
}
