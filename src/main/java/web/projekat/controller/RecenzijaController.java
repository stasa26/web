package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.RecenzijaService;

@RestController
public class RecenzijaController {
    @Autowired
    private RecenzijaService recenzijaService;
}
