package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Zanr;
@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {
}
