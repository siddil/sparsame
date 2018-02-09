package it.siddi.reallife.controlling.service;

import it.siddi.reallife.controlling.model.BasicReport;
import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ReportService {

    @Autowired
    private MovementRepository movementRepository;

    @Transactional(readOnly = true)
    public BasicReport reportOnMovements(Date from, Date to) {
        List<Movement> results = movementRepository.findByDate(from, to);
        BasicReport report = new BasicReport();
        for (Movement movement: results) {
            report.addMovement(movement);
        }
        report.produceReport();

        return report;
    }
}
