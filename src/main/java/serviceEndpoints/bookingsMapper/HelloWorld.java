package serviceEndpoints.bookingsMapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

@SpringBootApplication
@ContextConfiguration(locations = {"classpath:/spring-test-config-two.xml" })
@Component
@EnableRetry
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorld {

    @Value("${spring.application.name}")
    static String rikesh;

    public static void main(String[] args){
        retryTest();
    }

    @Bean
    @Retryable(value = {AssertionError.class}, maxAttempts = 5)
    public static void retryTest(){
        //System.out.println("HELLO");
        Assert.assertTrue(String.valueOf("200").equals("500"));
    }

}