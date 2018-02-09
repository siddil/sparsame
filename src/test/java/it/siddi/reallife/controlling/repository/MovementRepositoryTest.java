package it.siddi.reallife.controlling.repository;

import it.siddi.reallife.AppRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

@SpringApplicationConfiguration(classes = AppRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest("server.port:0")
@Transactional
@Ignore
public class MovementRepositoryTest {

    @Autowired
    private MovementRepository movementRepository;

    @Test
    public void testFindAll_andProducerWorked() {
        assertThat(movementRepository.findAll()).hasSize(1);
    }

    @Test
    public void findByNameAndPassword_andNoneFound() {
        assertThat(movementRepository.findByDate(new Date(), new Date())).isNull();
    }

    @Test
    public void findByNameAndPassword_andFoundOne() {
        assertThat(movementRepository.findByDate(new Date(), new Date())).isNotNull();
    }

}