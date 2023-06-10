package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.repository.ZahtevZaPrihvatanjeAutoraRepository;

@Service
public class ZahtevZaPrihvatanjeAutoraService {
    @Autowired
    private ZahtevZaPrihvatanjeAutoraRepository zahtevZaPrihvatanjeAutoraRepository;
}
