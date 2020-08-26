
package za.co.qdb.microservice.documents.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import za.co.qdb.documents.rest.model.Document;
import za.co.qdb.microservice.documents.api.domain.service.DocumentService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = CorsConfiguration.ALL)
@RequestMapping("/api/")
@RequiredArgsConstructor
public class DocumentsController implements za.co.qdb.documents.rest.api.DocumentsApi {

    @Autowired
    private DocumentService documentService;


    @Override
    public ResponseEntity<Boolean> deleteDocumentById(String id) {
        return ResponseEntity.ok(documentService.deleteDocumentById(id));
    }

    @Override
    public ResponseEntity<Document> getDocumentById(String id) {
        return ResponseEntity.ok(documentService.getDocumentById(id));
    }

    @Override
    public ResponseEntity<List<Document>> getDocuments() {
        return ResponseEntity.ok(documentService.getDocuments());
    }

    @Override
    public ResponseEntity<Document> saveDocument(@Valid za.co.qdb.documents.rest.model.DocumentRequest documentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(documentService.saveDocument(documentRequest));
    }
}
