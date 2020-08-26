package za.co.qdb.microservice.documents.api.domain.service;


import za.co.qdb.microservice.documents.api.domain.model.Document;

import java.util.List;

public interface DocumentService {
    za.co.qdb.documents.rest.model.Document saveDocument(za.co.qdb.documents.rest.model.DocumentRequest document);

    List<za.co.qdb.documents.rest.model.Document> getDocuments();

    za.co.qdb.documents.rest.model.Document getDocumentById(String id);

    boolean deleteDocumentById(String id);
}
