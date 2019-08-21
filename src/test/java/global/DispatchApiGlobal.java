package global;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.log4testng.Logger;

@ContextConfiguration(locations = {"classpath:/spring-test-config.xml","classpath:/spring-test-config-two.xml" })
public class DispatchApiGlobal extends AbstractTestNGSpringContextTests {

    @Getter
    @Value("${test.mock.endpoint}")
    private String endpoint;

    @Getter
    @Setter
    private static final Logger LOGGER = Logger.getLogger(DispatchApiGlobal.class);

    public void waitForGetCallToComplete(Response response){
        String statusLine = "";

        while (!statusLine.equals("HTTP/1.1 500")) {
            logger.info("Making call to API");
            statusLine = response.statusLine();
        }
    }
}