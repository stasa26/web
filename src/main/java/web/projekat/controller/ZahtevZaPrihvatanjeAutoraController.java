package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.ZahtevZaPrihvatanjeAutoraService;

@RestController
public class ZahtevZaPrihvatanjeAutoraController {
    @Autowired
    private ZahtevZaPrihvatanjeAutoraService zahtevZaPrihvatanjeAutoraService;
}
