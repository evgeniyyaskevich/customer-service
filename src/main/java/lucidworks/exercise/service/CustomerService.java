package lucidworks.exercise.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lucidworks.exercise.model.Customer;
import lucidworks.exercise.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;

  public Optional<Customer> findById(String customerId) {
    return customerRepository.findById(customerId);
  }

  public Customer create(Customer customer) {
    return customerRepository.insert(customer);
  }

  public void delete(String customerId) {
    customerRepository.deleteById(customerId);
  }

  public Page<Customer> list(int page, int size) {
    return customerRepository.findAll(PageRequest.of(page, size));
  }
}
