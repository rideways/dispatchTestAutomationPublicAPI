package bookingsEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import serviceEndpoints.bookingsMapper.MainBookings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@ContextConfiguration(locations = {"classpath:/spring-test-config.xml","classpath:/spring-test-config-two.xml" })
public class bookings extends AbstractTestNGSpringContextTests {

    String mockData = "./src/main/java/serviceEndpoints/mockData/bookings.json";

    @Value("${spring.application.name}")
    private String endpoint;

    /**
     * LINKS TEST SUITE
     * @return
     */
    @DataProvider(name="bookingsEndpointTypeTests")
    private Iterator<Object[]> setBookingsForType(){
        Collection<Object[]> dp = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {"Ensure the type return for links is correct where: ","A ....","POST"});
            }
        };

        return dp.iterator();
    }

    @Test(dataProvider="bookingsEndpointTypeTests",groups={"bookingsRegression","bookingTypeTests"})
    public void testBookingsEndpointType(String regressionTest, String testCondition, String expectedOutcome){

        ObjectMapper objectMapper = new ObjectMapper();

        MainBookings bookings = null;
        try {
            bookings = objectMapper.readValue(new File(mockData), MainBookings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookings.getBookings()[0].getLinks()[0].getType());

        Assert.assertTrue(expectedOutcome.equals(bookings.getBookings()[0].getLinks()[0].getType()));
    }

    /**
     * BOOKINGS TEST SUITE
     * @return
     */

    // LINKS

    // TESTS - TBD

    // REFERENCE

    @DataProvider(name="bookingsEndpointReferenceTests")
    private Iterator<Object[]> setBookingsForReference(){
        Collection<Object[]> dp = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {"Ensure the reference matches as expected","A ....","12345678"});
                add(new Object[] {"Ensure the reference is not the trip ID","A ....","12345678"});
                add(new Object[] {"Ensure the reference does not contain text","A ....","12345678"});
            }
        };

        return dp.iterator();
    }

    @Test(dataProvider="bookingsEndpointReferenceTests",groups={"bookingsRegression","bookingReferenceTests"})
    public void testBookingsEndpointReference(String regressionTest, String testCondition, String expectedOutcome){

        ObjectMapper objectMapper = new ObjectMapper();

        MainBookings bookings = null;
        try {
            bookings = objectMapper.readValue(new File(mockData), MainBookings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookings.getBookings()[0].getReference() + " : " + endpoint);

        Assert.assertTrue(expectedOutcome.equals(bookings.getBookings()[0].getReference()));
    }

    // DATE TESTS

    @DataProvider(name="bookingsEndpointDateTests")
    private Iterator<Object[]> setBookingsForDate(){
        Collection<Object[]> dp = new ArrayList<Object[]>()
        {
            {
                add(new Object[] {"Ensure the pickup date time is in the correct format","A ....","POST"});
            }
        };

        return dp.iterator();
    }


    @Test(dataProvider="bookingsEndpointDateTests",groups={"bookingsRegression","bookingDateTests"})
    public void testBookingsEndpointDate(String regressionTest, String testCondition, String expectedOutcome){

        ObjectMapper objectMapper = new ObjectMapper();

        MainBookings bookings = null;
        try {
            bookings = objectMapper.readValue(new File(mockData), MainBookings.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(bookings.getBookings()[0].getPickup_date_time());
    }

}
