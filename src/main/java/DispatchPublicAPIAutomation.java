import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.ContextConfiguration;

@EnableRetry
@ContextConfiguration(locations = {"classpath:/spring-test-config.xml","classpath:/spring-test-config-two.xml" })
@SpringBootApplication
public class DispatchPublicAPIAutomation {

    public static void main(String[] args){
        SpringApplication.run(DispatchPublicAPIAutomation.class,args);
    }
}
