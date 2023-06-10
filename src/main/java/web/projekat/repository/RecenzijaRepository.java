package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Recenzija;
@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
}
