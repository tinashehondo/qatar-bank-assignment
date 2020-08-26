package za.co.qdb.microservice.documents.api.domain.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.documents.rest.model.DocumentRequest;
import za.co.qdb.microservice.documents.api.domain.mappers.DocumentMapper;
import za.co.qdb.microservice.documents.api.domain.model.Document;
import za.co.qdb.microservice.documents.api.domain.repository.DocumentRepository;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class DocumentServiceImplTest {

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private DocumentMapper documentMapper;

    @InjectMocks
    private DocumentServiceImpl documentService;

    @Test
    void saveDocument() {
        when(documentRepository.save(any(Document.class))).thenReturn(new Document());
        when(documentMapper.apply(any())).thenReturn(new za.co.qdb.documents.rest.model.Document());
        za.co.qdb.documents.rest.model.Document response = documentService.saveDocument(new DocumentRequest());
        Assert.assertNotNull(response);
        verify(documentMapper,times(1)).apply(any(Document.class));
    }

    @Test
    void getDocuments() {
        Document doc1 = new Document();
        List<Document> docs = new ArrayList<>();
        docs.add(doc1);
        when(documentRepository.findAll()).thenReturn(docs);


        when(documentMapper.apply(any())).thenReturn(new za.co.qdb.documents.rest.model.Document());
        List<za.co.qdb.documents.rest.model.Document> response = documentService.getDocuments();
        Assert.assertNotNull(response);
        Assert.assertEquals(response.size(),1);
        verify(documentMapper,times(1)).apply(any(Document.class));
    }

    @Test
    void getDocumentById() {
        when(documentRepository.findById(any())).thenReturn(java.util.Optional.of(new Document()));

        when(documentMapper.apply(any())).thenReturn(new za.co.qdb.documents.rest.model.Document());
        za.co.qdb.documents.rest.model.Document response = documentService.getDocumentById("1");
        Assert.assertNotNull(response);
        verify(documentMapper,times(1)).apply(any(Document.class));
    }

    @Test
    void deleteDocumentById() {
        when(documentRepository.findById(any())).thenReturn(java.util.Optional.of(new Document()));

        when(documentMapper.apply(any())).thenReturn(new za.co.qdb.documents.rest.model.Document());
        boolean response = documentService.deleteDocumentById("1");
        Assert.assertTrue(response);
    }
}