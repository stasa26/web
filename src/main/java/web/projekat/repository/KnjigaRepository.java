package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Knjiga;

public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}
