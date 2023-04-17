package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Recenzija;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
}
