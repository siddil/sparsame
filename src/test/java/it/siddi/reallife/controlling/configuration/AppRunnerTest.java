package it.siddi.reallife.controlling.configuration;

import it.siddi.reallife.AppRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppRunnerTest {

    @Test
    @Ignore
    public void bootstrapsApplication() {
        new AnnotationConfigApplicationContext(AppRunner.class);
    }
}
