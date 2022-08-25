package lucidworks.exercise.rest;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lucidworks.exercise.model.Customer;
import lucidworks.exercise.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/customer")
@Validated
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<?> health() {
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{customerId}")
  public Customer findById(@PathVariable String customerId) {
    return customerService.findById(customerId)
        .orElseThrow(NotFoundException::new);
  }

  @PostMapping
  public Customer create(@Valid @RequestBody Customer customer) {
    return customerService.create(customer);
  }

  @DeleteMapping("/{customerId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable String customerId) {
    customerService.delete(customerId);
  }
}
