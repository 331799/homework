package com.homework.test.api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ApiTest extends ApiBasicTestCase {

    public final static Logger logger = Logger.getLogger(ApiTest.class);

    private String productName = "Apartment Gaudelet";
    private int countryId = 21980;
    private String startDateMonday = "";
    private String endDateSunday = "";
    private String pos = "a502d2c65c2f75d3";
    private int productId = 0;

    @BeforeClass
    private void produceDates() {
        LocalDate now = LocalDate.now();
        TemporalField fieldISO = WeekFields.of(Locale.UK).dayOfWeek();
        startDateMonday = String.valueOf(now.with(fieldISO, 1).plusDays(7));
        endDateSunday = String.valueOf(now.with(fieldISO, 1).plusDays(14));
        logger.info("Search startDateMonday: " + startDateMonday);
        logger.info("Search endDateSunday: " + endDateSunday);
        logger.info("Expecting hotel: " + productName);
    }

    @Test
    public void apiTest() throws MalformedURLException {
        //get list of hotels
        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .get("/reservation/products/" + countryId + "/" + startDateMonday + "/" + endDateSunday + "?" +
                        "pos=" + pos + "&guests=2&amenity=true&currency=USD&" +
                        "exec_match=false&display_inquire_only=false");

        JsonPath jsonPath = response.jsonPath();
        int quotesAmount = jsonPath.get("search_response.search_quotes.quote.size");
        logger.info("Amount of hotels: " + quotesAmount);

        //find hotel product id
        for (int i = 0; i < quotesAmount; i++) {
            if (jsonPath.get("search_response.search_quotes.quote[" + i + "].productname").toString().equals(productName)) {
                productId = jsonPath.get("search_response.search_quotes.quote[" + i + "].productid");
                logger.info("ProductId for " + productName + ": " + productId);
            }
        }

        //assert is hotel exist
        assertNotEquals(productId, 0);

        //get quote by productId
        Response quoteResponse = given()
                .accept(ContentType.JSON)
                .when()
                .get("/reservation/quotes?pos=a502d2c65c2f75d3&productid=" + productId + "&" +
                        "fromdate=" + startDateMonday + "&todate=" + endDateSunday + "&currency=USD&adults=2");

        JsonPath quoteJsonPath = quoteResponse.jsonPath();
        String quote = quoteJsonPath.get("quotes.quote").toString();
        String price = quoteJsonPath.get("quotes.price").toString();
        logger.info("Price: " + price);
        logger.info("Quote: " + quote);

        // assert quote == price
        assertEquals(quote, price);
    }
}
