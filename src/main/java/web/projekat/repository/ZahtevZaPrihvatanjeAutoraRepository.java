package web.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.projekat.entity.ZahtevZaPrihvatanjeAutora;
@Repository
public interface ZahtevZaPrihvatanjeAutoraRepository extends JpaRepository<ZahtevZaPrihvatanjeAutora, Long> {
}
