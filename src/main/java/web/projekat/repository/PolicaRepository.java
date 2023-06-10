package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Polica;
@Repository
public interface PolicaRepository extends JpaRepository<Polica, Long> {
}
