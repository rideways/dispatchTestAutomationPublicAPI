package serviceEndpoints.bookingsMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Pickup {
    @Getter
    Float latitude;

    @Getter
    Float longitude;

    @Getter
    String address;

    @Getter
    String postcode;

    @Getter
    String country;

    @Getter
    String type;
}
