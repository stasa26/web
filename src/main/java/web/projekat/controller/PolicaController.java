package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.PolicaService;

@RestController
public class PolicaController {
    @Autowired
    private PolicaService policaService;
}
