package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
}
