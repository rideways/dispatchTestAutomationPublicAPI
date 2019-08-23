package global;


import global.DispatchConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(locations = {"classpath:/spring-test-config.xml"})
@RunWith(SpringRunner.class)
@Configuration
@ComponentScan(basePackageClasses = DispatchConfigurator.class)
@SpringBootTest
@EnableRetry
public class DispatchAPI {

    @Autowired
    private DispatchConfigurator dispatchConfigurator;

    @Test
    public void newTestAPI(){
        dispatchConfigurator.dispatchConfigurator();
    }
}
