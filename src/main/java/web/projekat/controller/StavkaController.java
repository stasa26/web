package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.StavkaDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Stavka;
import web.projekat.service.StavkaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class StavkaController {
    @Autowired
    private StavkaService stavkaService;
    @GetMapping("stavka/{id}")
    public ResponseEntity<StavkaDto> getStavka(@PathVariable Long id) {
        Stavka stavka = stavkaService.findOne(id);
        if (stavka == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new StavkaDto(stavka));
    }

    @GetMapping("stavke")
    public ResponseEntity<List<StavkaDto>> getStavke() {
        List<Stavka> stavke = stavkaService.findAll();
        List<StavkaDto> dtos = new ArrayList<>();
        for (Stavka stavka : stavke)
            dtos.add(new StavkaDto(stavka));
        return ResponseEntity.ok(dtos);
    }
}
