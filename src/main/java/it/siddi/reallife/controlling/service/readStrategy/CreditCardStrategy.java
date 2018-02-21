package it.siddi.reallife.controlling.service.readStrategy;

import com.google.common.collect.Lists;
import it.siddi.reallife.controlling.model.Movement;
import it.siddi.reallife.controlling.model.MovementType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CreditCardStrategy implements ReadStrategy {

    private Log logger = LogFactory.getLog(CreditCardStrategy.class);

    @Override
    public List<Movement> readDoc(String[] contents) {
        List<Movement> movements = Lists.newArrayList();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String[] relevant = Arrays.copyOfRange(contents, 8, contents.length-1);
        for (String line:relevant) {
            String[] content = line.split(";");
            String date = content[2].replace("\"","");
            try {
                Date dateMovement=formatter.parse(date);
                String reason = content[3].replace("\"","");
                String amountAsString = content[4].replace("\"", "").replace(".","").replace(',','.');
                logger.info(date+" "+ reason +" "+ amountAsString);
                Float amount = Float.parseFloat(amountAsString);
                Movement movement = new Movement(dateMovement,reason,amount, MovementType.UNDEF);
                movements.add(movement);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return movements;
    }
}
