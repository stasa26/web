package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.KnjigaService;

@RestController
public class KnjigaController {
    @Autowired
    private KnjigaService knjigaService;
}
