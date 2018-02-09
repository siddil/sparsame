package it.siddi.reallife.controlling.controller;

import it.siddi.reallife.controlling.model.BasicReport;
import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.service.MovementService;
import it.siddi.reallife.controlling.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/movements", method = RequestMethod.GET)
    public List<Movement> getMovement(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date from, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {
        return movementService.getMovements(from, to);
    }

    @RequestMapping(value = "/movement", method = RequestMethod.POST)
    public Movement addMovement(@RequestBody Movement movement) {
        return movementService.addMovement(movement);
    }

    @RequestMapping(value = "/movements_report", method = RequestMethod.GET)
    public BasicReport getReport(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date from, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {
        return reportService.reportOnMovements(from,to);
    }
}
