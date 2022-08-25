package lucidworks.exercise.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer/v1")
public class CustomerController {

  @GetMapping
  public ResponseEntity<?> health() {
    return ResponseEntity.ok().build();
  }
}
