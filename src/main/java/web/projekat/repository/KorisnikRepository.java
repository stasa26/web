package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.dto.KorisnikDto;
import web.projekat.entity.Korisnik;

import java.util.Optional;

@Repository

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Optional<Korisnik> findByEmail(String email);
    Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
}
