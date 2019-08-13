package bookingsEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serviceEndpoints.bookingsMapper.MainBookings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class bookings {

    @DataProvider(name="bookingsEndpointDateTests")
    private Iterator<Object[]> setBookingsForDate(){
        Collection<Object[]> dp = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {"Ensure the pickup date time is in the correct format",""});
            }
        };

        return dp.iterator();
    }

    @DataProvider(name="bookingsEndpointTypeTests")
    private Iterator<Object[]> setBookingsForType(){
        Collection<Object[]> dp = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {"Ensure the type return for links is correct",""});
            }
        };

        return dp.iterator();
    }

    @Test(dataProvider="bookingsEndpointDateTests",groups={"regression","bookingDateTests"})
    public void testBookingsEndpointDate(String regressionTest, String test){

        ObjectMapper objectMapper = new ObjectMapper();

        MainBookings bookings = null;
        try {
            bookings = objectMapper.readValue(new File("C:\\Users\\gohilri\\Documents\\01.Github_Projects\\dispatchPublicAPI\\src\\main\\java\\serviceEndpoints\\bookingsMapper\\bookings.json"), MainBookings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookings.getBookings()[0].getPickup_date_time());
    }

    @Test(dataProvider="bookingsEndpointTypeTests",groups={"regression","bookingTypeTests"})
    public void testBookingsEndpointType(String regressionTest, String test){

        ObjectMapper objectMapper = new ObjectMapper();


        MainBookings bookings = null;
        try {
            bookings = objectMapper.readValue(new File("./src/main/java/serviceEndpoints/bookingsMapper/bookings.json"), MainBookings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookings.getBookings()[0].getLinks()[0].getType());
    }
}
