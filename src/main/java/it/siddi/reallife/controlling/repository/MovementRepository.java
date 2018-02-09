package it.siddi.reallife.controlling.repository;

import it.siddi.reallife.controlling.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long>{

    @Query("SELECT m FROM Movement m WHERE m.date BETWEEN :from and :to")
    List<Movement> findByDate
            (
                    @Param("from") Date dateFrom,
                    @Param("to") Date dateTo
            );

}
