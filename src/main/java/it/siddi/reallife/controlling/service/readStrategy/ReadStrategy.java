package it.siddi.reallife.controlling.service.readStrategy;

import it.siddi.reallife.controlling.model.Movement;

import java.util.List;

public interface ReadStrategy {

    List<Movement> readDoc(String[] contents);
}
