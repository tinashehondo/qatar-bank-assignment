package za.co.qdb.microservice.documents.api.domain.mappers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.microservice.documents.api.domain.model.Document;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class DocumentMapperTest {

    @InjectMocks
    private DocumentMapper documentMapper;

    @Test
    void apply() {
        Document documentSource =
        Document.builder()
                .description("Test description")
                .file("asfafafafafs")
                .format("pdf")
                .id("1")
                .build();
        za.co.qdb.documents.rest.model.Document documentOutput = documentMapper.apply(documentSource);
        Assert.assertNotNull(documentOutput);
        Assert.assertTrue(documentOutput.getName().equals(documentSource.getDescription()));
        Assert.assertTrue(documentOutput.getDocument().equals(documentSource.getFile()));
        Assert.assertTrue(documentOutput.getFormat().equals(documentSource.getFormat()));
        Assert.assertTrue(documentOutput.getId().equals(documentSource.getId()));
    }
}