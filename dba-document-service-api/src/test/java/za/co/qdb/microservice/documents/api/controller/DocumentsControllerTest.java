package za.co.qdb.microservice.documents.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import za.co.qdb.documents.rest.model.Document;
import za.co.qdb.documents.rest.model.DocumentRequest;
import za.co.qdb.microservice.documents.api.domain.service.DocumentService;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DocumentsControllerTest {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    @Sql("/document_insert.sql")
    void deleteDocumentById() throws Exception {
        mockMvc.perform(delete("/api/documents/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

    }

    @Test
    @Sql("/document_insert.sql")
    void getDocumentById() throws Exception {
        mockMvc.perform(get("/api/documents/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("pdf")));

    }

    @Test
    @Sql("/document_insert.sql")
    void getDocuments() throws Exception {

        mockMvc.perform(get("/api/documents")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("pdf")));

    }

    @Test
    void saveDocument() throws Exception {
        za.co.qdb.documents.rest.model.DocumentRequest documentRequest = new DocumentRequest();
        documentRequest.setDocument("asfasfasfafs");
        documentRequest.setFormat("pdf");
        documentRequest.setName("id");

        mockMvc.perform(post("/api/documents", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(documentRequest)))
                .andExpect(status().is(201));
        List<Document> documents = documentService.getDocuments();
        Assert.assertTrue(documents.size() >0);
        Assert.assertTrue(documents.get(0).getName().equals("id"));
    }
}