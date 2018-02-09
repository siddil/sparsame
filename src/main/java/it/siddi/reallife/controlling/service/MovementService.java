package it.siddi.reallife.controlling.service;

import com.google.common.collect.Lists;
import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional
public class MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Transactional(readOnly = true)
    public List<Movement> getMovements(Date from, Date to) {
        List<Movement> results = Lists.newArrayList();
        results.addAll(movementRepository.findByDate(from, to));
        return results;
    }

    public Movement addMovement(Movement movement) {
        movementRepository.save(movement);
        return movement;
    }
}
