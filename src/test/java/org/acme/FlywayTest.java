package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;


@QuarkusTest
public class FlywayTest {

    @Inject
    Flyway flyway;

    @Test
    public void helloEndpoint_whenMigrationIsSuccessful_returnsCorrectValues() {
        Assertions.assertEquals(0, flyway.info().pending().length);

        given().when()
               .get("/hello")
               .then()
               .statusCode(200)
               .body("$.size()", is(3),
                     "name", containsInAnyOrder("Leonard Leakey Hofstadter", "Penny Hofstadter", "Sheldon Lee Cooper"));
    }
}
