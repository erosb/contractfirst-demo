package com.hazelcast.demo.contractfirst;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerIntegrationTest {

    @LocalServerPort
    int port;
    
    @Test
    public void testCreatePerson() {
        given().port(port)
                .filter(new OpenApiValidationFilter("/person-api.yaml"))
                .contentType("application/json")
                .when().body("{\"userName\":\"John Doe\", \"age\":20, \"emails\":\"johndoe@example.com\"}")
                .post("/person")
                .then().statusCode(200)
                ;
    }
    
}
