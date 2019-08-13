package serviceEndpoints.bookingsMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class MainBookings {

    @Getter
    Links[] links;

    @Getter
    Bookings[] bookings;
}
