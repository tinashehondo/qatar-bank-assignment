package za.co.qdb.microservice.documents.api.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.qdb.microservice.documents.api.domain.mappers.DocumentMapper;
import za.co.qdb.microservice.documents.api.domain.model.Document;
import za.co.qdb.microservice.documents.api.domain.repository.DocumentRepository;
import za.co.qdb.microservice.documents.api.domain.service.DocumentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public za.co.qdb.documents.rest.model.Document saveDocument(za.co.qdb.documents.rest.model.DocumentRequest doc) {
        Document document = Document.builder()
                .description(doc.getName())
                .file(doc.getDocument())
                .id(UUID.randomUUID().toString())
                .format(doc.getFormat())
                .build();
        Document savedDocument = documentRepository.save(document);
        return documentMapper.apply(savedDocument);
    }

    @Override
    public List<za.co.qdb.documents.rest.model.Document> getDocuments() {
        List<za.co.qdb.documents.rest.model.Document> documents = new ArrayList<>();
        documentRepository.findAll().forEach(document -> documents.add(documentMapper.apply(document)));
        return documents;
    }

    @Override
    public za.co.qdb.documents.rest.model.Document getDocumentById(String id) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()){
            return documentMapper.apply(optionalDocument.get());
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteDocumentById(String id) {
        Optional<Document> documentOptional = documentRepository.findById(id);
        if (documentOptional.isPresent()){
            documentRepository.delete(documentOptional.get());
            return true;
        }else{
            return false;
        }
    }
}
