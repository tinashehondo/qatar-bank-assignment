package za.co.qdb.microservice.documents.api.domain.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.qdb.microservice.documents.api.domain.model.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, String> {
}
