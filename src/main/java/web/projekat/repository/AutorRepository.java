package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
