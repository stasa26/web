package web.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.projekat.repository.ZanrRepository;

@Service
public class ZanrService {
    @Autowired
    private ZanrRepository zanrRepository;
}
