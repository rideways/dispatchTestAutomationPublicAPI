package bookingsEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.*;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.TestPropertySource;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import serviceEndpoints.bookingsMapper.MainBookings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static io.restassured.RestAssured.given;

@RunWith(SpringJUnit4ClassRunner.class)
//@EnableAutoConfiguration
@SpringBootApplication
@SpringBootTest
public class bookings {

    String mockData = "./src/main/java/serviceEndpoints/mockData/bookings.json";

    public bookings(){

    }

    //private static final Logger LOGGER = Logger.getLogger(bookings.class);

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

    //@Test(dataProvider="bookingsEndpointTypeTests",groups={"bookingsRegression","bookingTypeTests"})
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
               // add(new Object[] {"Ensure the reference is not the trip ID","A ....","12345678"});
               // add(new Object[] {"Ensure the reference does not contain text","A ....","12345678"});
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

        //System.out.println(bookings.getBookings()[0].getReference() + " : " + getEndpoint());

        //ValidatableResponse abc = given().when().get(getEndpoint()).then().statusCode(200);

        //LOGGER.info("THIS IS A TEST");

//        int code = given().when().get(getEndpoint()).statusCode();


        int code = 200;

        //dispatchConfiguration.retryTest();

/*        RestAssured.baseURI = getEndpoint();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        waitForResponse(response);*/

        //Assert.assertTrue(expectedOutcome.equals(bookings.getBookings()[0].getReference()));
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


    //@Test(dataProvider="bookingsEndpointDateTests",groups={"bookingsRegression","bookingDateTests"})
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
