package lucidworks.exercise.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Customer")
public class Customer {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  @CreatedDate
  private LocalDateTime creationDate;
  @LastModifiedDate
  private LocalDateTime modificationDate;
}
