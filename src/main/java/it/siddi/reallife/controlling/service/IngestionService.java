package it.siddi.reallife.controlling.service;


import com.google.common.collect.Lists;
import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.repository.MovementRepository;
import it.siddi.reallife.controlling.service.readStrategy.AccountStrategy;
import it.siddi.reallife.controlling.service.readStrategy.CreditCardStrategy;
import it.siddi.reallife.controlling.service.readStrategy.NotSupportedStrategyException;
import it.siddi.reallife.controlling.service.readStrategy.ReadStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class IngestionService {

    private Log logger = LogFactory.getLog(IngestionService.class);

    @Autowired
    private KeywordsCategoryService categoryService;

    @Autowired
    private MovementRepository repo;

    public List<String> addMovementSheet(MultipartFile file) throws NotSupportedStrategyException {
        try {
            byte[] bytes = file.getBytes();
            String completeData = new String(bytes);
            String[] rows = completeData.split("\\r?\\n");
            String[] columns = rows[0].split(";");
            ReadStrategy strategy = giveReader(columns);
            List<Movement> movements = strategy.readDoc(rows);
            repo.save(movements);
            categoryService.buildTermsMap();
            return Lists.newArrayList();
        } catch (IOException e) {
            logger.fatal(e.getMessage());
            return Lists.newArrayList();
        }
    }



    private ReadStrategy giveReader(String[] columns) throws NotSupportedStrategyException {
        if(columns[0] != null){
            logger.info("column 0 ="+columns[0]);
            if("\"Kontonummer:\"".equals(columns[0])){ return new AccountStrategy();}
            if("\"Kreditkarte:\"".equals(columns[0])){ return new CreditCardStrategy();}
        }
            throw new NotSupportedStrategyException();

    }

}

