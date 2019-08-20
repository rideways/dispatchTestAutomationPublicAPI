package serviceEndpoints.bookingsMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@PropertySource("classpath:/application.dev.properties")
@Component
public class HelloWorld {

    @Value("${spring.application.name}")
    static String rikesh;

    public static void main(String[] args){
        System.out.println(rikesh);
    }
}