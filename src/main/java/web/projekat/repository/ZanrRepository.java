package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.projekat.entity.Zanr;

public interface ZanrRepository extends JpaRepository<Zanr, Long> {
}
