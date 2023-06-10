package web.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import web.projekat.service.ZanrService;

@RestController
public class ZanrController {
    @Autowired
    private ZanrService zanrService;
}
