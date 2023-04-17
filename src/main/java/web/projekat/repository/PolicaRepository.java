package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Polica;

public interface PolicaRepository extends JpaRepository<Polica, Long> {
}
