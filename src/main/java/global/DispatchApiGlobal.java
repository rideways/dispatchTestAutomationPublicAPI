package global;

import lombok.Getter;
import lombok.Setter;
import org.testng.log4testng.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"classpath:/spring-test-config.xml","classpath:/spring-test-config-two.xml" })
public class DispatchApiGlobal extends AbstractTestNGSpringContextTests {

    public Logger LOGGER = Logger.getLogger(DispatchApiGlobal.class);

    @Getter
    @Value("${test.mock.endpoint}")
    private String endpoint;

    public void waitForResponse(Response response){
        LOGGER.info("MAKING CALL TO API");
        int statusLine = response.statusCode();

        System.out.println(statusLine);

        while (!String.valueOf(statusLine).equals("200")){
           LOGGER.info("MAKING CALL TO API #2");
           statusLine = response.statusCode();
        }

    }
}