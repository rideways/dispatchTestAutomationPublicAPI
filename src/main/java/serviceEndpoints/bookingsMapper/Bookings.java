package serviceEndpoints.bookingsMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Bookings {

    @Getter
    Links[] links;

    @Getter
    String reference;

    @Getter
    String state_hash;

    @Getter
    String status;

    @Getter
    Price price;

    @Getter
    String pickup_date_time;

    @Getter
    String pickup_date_time_zone;

    @Getter
    String vehicle_type;

    @Getter
    String additional_comments;

    @Getter
    String passenger_count;

    @Getter
    Boolean meet_and_greet;

    @Getter
    String meet_and_greet_message;

    @Getter
    Passenger passenger;

    @Getter
    Pickup pickup;

    @Getter
    Dropoff dropoff;
}
