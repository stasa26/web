package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Stavka;

public interface StavkaRepository extends JpaRepository<Stavka, Long> {
}
