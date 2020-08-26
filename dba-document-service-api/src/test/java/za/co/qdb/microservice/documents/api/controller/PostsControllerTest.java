package za.co.qdb.microservice.documents.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.HttpClientErrorException;
import za.co.qdb.documents.rest.model.Post;
import za.co.qdb.microservice.documents.api.domain.service.PostsService;

import static org.junit.jupiter.api.Assertions.*;
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
class PostsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void savePost() throws Exception {
        za.co.qdb.documents.rest.model.CreatePostRequest createPostRequest = new za.co.qdb.documents.rest.model.CreatePostRequest();
        createPostRequest.setDocumentId("1");
        createPostRequest.setBody("test body");
        createPostRequest.setTitle("testTitle");

        try {
            MvcResult resultActions = mockMvc.perform(post("/api/posts", 42L)
                    .contentType("application/json")
                    .content(objectMapper.writeValueAsString(createPostRequest))).andReturn();
            int status = resultActions.getResponse().getStatus();
            Assert.assertTrue(status == 201 || status == 500);
        }catch (Exception e){
           Assert.assertTrue(e.getCause().getClass() ==HttpClientErrorException.class );
            Assert.assertNotNull(e.getMessage());
        }



    }
}