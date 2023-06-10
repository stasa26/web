package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Stavka;
@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {
}
