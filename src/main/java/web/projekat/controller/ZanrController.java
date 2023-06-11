package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.dto.KnjigaDto;
import web.projekat.dto.ZanrDto;
import web.projekat.entity.Knjiga;
import web.projekat.entity.Zanr;
import web.projekat.service.ZanrService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ZanrController {
    @Autowired
    private ZanrService zanrService;
    @GetMapping("zanr/{id}")
    public ResponseEntity<ZanrDto> getZanr(@PathVariable Long id) {
        Zanr zanr = zanrService.findOne(id);
        if (zanr == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(new ZanrDto(zanr));
    }

    @GetMapping("zanrovi")
    public ResponseEntity<List<ZanrDto>> getZanrovi() {
        List<Zanr> zanrovi = zanrService.findAll();
        List<ZanrDto> dtos = new ArrayList<>();
        for (Zanr zanr : zanrovi)
            dtos.add(new ZanrDto(zanr));
        return ResponseEntity.ok(dtos);
    }
}
