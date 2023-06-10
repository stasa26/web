package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Knjiga;
@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {
}
