package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.repository.RecenzijaRepository;

@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
}
