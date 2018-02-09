package it.siddi.reallife.controlling.producer;

import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.service.MovementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class MovementProducer {
    private Log logger = LogFactory.getLog(MovementProducer.class);

    private MovementService movementService;

    @Autowired
    public MovementProducer(MovementService movementService) {
        this.movementService = movementService;
    }


    private void findMovements(Date from, Date to) {
        logger.info("Trying to find all movements.");
        List<Movement> allMovements = movementService.getMovements(from, to);
        if(allMovements.isEmpty()) {
            logger.info("--No controlling found--");
        } else {
            for (Movement foundMovement : allMovements) {
                logger.info(String.format("controlling with id %d and name %s found :)", foundMovement.getId(), foundMovement.getDate()));
            }
        }
    }
}
