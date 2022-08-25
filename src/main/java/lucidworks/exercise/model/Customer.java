package lucidworks.exercise.model;

import java.time.LocalDateTime;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Customer")
public class Customer {
  @Id
  private String id;
  @Size(min = 3, max = 15, message = "first.name.size.must.be.from.3.to.15")
  private String firstName;
  @Size(min = 3, max = 15, message = "last.name.size.must.be.from.3.to.15")
  private String lastName;
  @CreatedDate
  private LocalDateTime creationDate;
  @LastModifiedDate
  private LocalDateTime modificationDate;
  @Version
  private Long version;
}
