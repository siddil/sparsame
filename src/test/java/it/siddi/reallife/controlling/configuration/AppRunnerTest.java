package it.siddi.reallife.controlling.configuration;

import it.siddi.reallife.AppRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableWebMvc
@Ignore
public class AppRunnerTest {


    @Test
    public void bootstrapsApplication() {
        new AnnotationConfigApplicationContext(AppRunner.class);
    }

}
