package serviceEndpoints.bookingsMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Passenger {

    @Getter
    String title;

    @Getter
    String name;

    @Getter
    String telephone_number;
}
