package global;

import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

public interface DispatchInter {

    @Retryable(value = {AssertionError.class}, maxAttemptsExpression = "3")
    public AssertionError dispatchConfigurator();
}
