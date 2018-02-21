package it.siddi.reallife.controlling.service;

import it.siddi.reallife.controlling.model.MovementKeyWords;
import it.siddi.reallife.controlling.repository.MovementKeywordsRepository;
import it.siddi.reallife.controlling.repository.MovementRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordsCategoryService {


    private Log logger = LogFactory.getLog(IngestionService.class);

    @Autowired
    private MovementKeywordsRepository keyWordsRepo;

    @Autowired
    private MovementRepository movementRepo;


    public void buildTermsMap() {
        List<MovementKeyWords> terms = keyWordsRepo.findAll();
        for (MovementKeyWords keyword : terms) {
            movementRepo.updateType(keyword.getType(), keyword.getKeyword());
        }
    }
}
