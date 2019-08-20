package global;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(locations = {"classpath:/spring-test-config.xml","classpath:/spring-test-config-two.xml" })
public class DispatchApiGlobal extends AbstractTestNGSpringContextTests {

    @Getter
    @Value("${test.mock.endpoint}")
    private String endpoint;
}