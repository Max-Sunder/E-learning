package Backend.repository;

import Backend.entities.CycleScolaire;
import Backend.entities.Systeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleScolaireRepository extends JpaRepository<CycleScolaire, String> {
    CycleScolaire findByName(@Param("cycle_name") String systemeName); //On reporte le nom du param dans la requete
    @Query(
            value = " select c from CycleScolaire c " +
                    "LEFT JOIN FETCH c.sousSystemeEducatif sousSystemeEducatif " +
                    "where sousSystemeEducatif.id = :sousSystemeId")
    List<CycleScolaire> findAllCycleBySousSystemeId(String sousSystemeId);
}
