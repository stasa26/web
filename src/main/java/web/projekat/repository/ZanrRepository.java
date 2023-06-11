package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Zanr;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {
    Optional<Zanr> findByNaziv(String naziv);
}
