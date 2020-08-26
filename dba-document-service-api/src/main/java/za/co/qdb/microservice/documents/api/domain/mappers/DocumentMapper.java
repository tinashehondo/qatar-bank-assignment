package za.co.qdb.microservice.documents.api.domain.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.qdb.microservice.documents.api.domain.model.Document;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class DocumentMapper implements Function<Document, za.co.qdb.documents.rest.model.Document> {

    @Override
    public za.co.qdb.documents.rest.model.Document apply(Document doc) {
        za.co.qdb.documents.rest.model.Document document = new za.co.qdb.documents.rest.model.Document();
        document.setDocument(doc.getFile());
        document.setFormat(doc.getFormat());
        document.setId(doc.getId());
        document.setName(doc.getDescription());
        return document;
    }
}
