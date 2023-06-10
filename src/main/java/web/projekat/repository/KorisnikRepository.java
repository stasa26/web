package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.dto.KorisnikDto;
import web.projekat.entity.Korisnik;

@Repository

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByEmail(String email);
    Korisnik findByPassword(String password);
    Korisnik getByEmail(String email);
}
