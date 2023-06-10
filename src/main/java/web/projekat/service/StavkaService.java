package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.repository.StavkaRepository;

@Service
public class StavkaService {
    @Autowired
    private StavkaRepository stavkaRepository;
}
