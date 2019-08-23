package global;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public abstract class DispatchConfigurator implements DispatchInter {

    @Override
    @Retryable(value = {AssertionError.class}, maxAttempts = 5)
    @Bean
    public AssertionError dispatchConfigurator(){
        throw new AssertionError("");
    }
}
