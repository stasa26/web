package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.repository.PolicaRepository;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
}
