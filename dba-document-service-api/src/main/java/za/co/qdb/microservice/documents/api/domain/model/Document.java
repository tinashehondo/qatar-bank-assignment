package za.co.qdb.microservice.documents.api.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    private String id;
    @Lob
    private String file;
    private String format;
    private String description;


}
