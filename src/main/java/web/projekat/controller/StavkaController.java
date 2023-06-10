package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.StavkaService;

@RestController
public class StavkaController {
    @Autowired
    private StavkaService stavkaService;
}
