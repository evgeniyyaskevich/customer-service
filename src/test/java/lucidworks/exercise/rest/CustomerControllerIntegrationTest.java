package lucidworks.exercise.rest;

import lucidworks.exercise.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIntegrationTest {

  private static final String CUSTOMER_API_URI = "/v1/customer";
  private static final String FIRST_NAME = "FirstName";
  private static final String LAST_NAME = "LastName";
  private static final String CREATION_DATE = "creationDate";
  private static final String MODIFICATION_DATE = "modificationDate";
  private static final String FIRST_NAME_PATH = "$.firstName";
  private static final String LAST_NAME_PATH = "$.lastName";

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void shouldSaveCustomerEntity() {
    var customer = Customer.builder()
        .firstName(FIRST_NAME)
        .lastName(LAST_NAME)
        .build();

    webTestClient.post()
        .uri(CUSTOMER_API_URI)
        .contentType(MediaType.APPLICATION_JSON)
        .body(BodyInserters.fromValue(customer))
        .exchange()
        .expectStatus().isCreated()
        .expectBody()
        .jsonPath(FIRST_NAME_PATH).isEqualTo(FIRST_NAME)
        .jsonPath(LAST_NAME_PATH).isEqualTo(LAST_NAME)
        .jsonPath(CREATION_DATE).isNotEmpty()
        .jsonPath(MODIFICATION_DATE).isNotEmpty();
  }
}
