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
import org.springframework.web.client.HttpClientErrorException;
import za.co.qdb.documents.rest.model.Document;
import za.co.qdb.documents.rest.model.DocumentRequest;
import za.co.qdb.microservice.documents.api.domain.service.CommentsService;
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
class CommentsControllerTest {
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void saveComment() throws Exception {
        za.co.qdb.documents.rest.model.CreateCommentRequest createCommentRequest = new za.co.qdb.documents.rest.model.CreateCommentRequest();
        createCommentRequest.setBody("sfasfasfsaf");
        createCommentRequest.setEmail("email@test.com");
        createCommentRequest.setName("name");
        createCommentRequest.setPostId("101");
try {
        mockMvc.perform(post("/api/comments", 42L)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(createCommentRequest)))
                .andExpect(status().is(201));
    }catch (Exception e){
        Assert.assertTrue(e.getCause().getClass() == HttpClientErrorException.class );
        Assert.assertNotNull(e.getMessage());
    }
    }
}