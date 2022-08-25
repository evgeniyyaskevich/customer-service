package lucidworks.exercise.rest;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import lombok.RequiredArgsConstructor;
import lucidworks.exercise.model.Customer;
import lucidworks.exercise.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/customer")
@Validated
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

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

  @GetMapping
  public Page<Customer> list(
      @RequestParam(defaultValue = "1") @Min(1) int page,
      @RequestParam(defaultValue = "10") @Min(1) int size) {
    return customerService.list(page, size);
  }
}
