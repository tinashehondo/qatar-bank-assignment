package za.co.qdb.microservice.documents.api.domain.mappers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.documents.rest.model.CreatePostRequest;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PostsRequestMapperTest {
    @InjectMocks
    private PostsRequestMapper postsRequestMapper;

    @Test
    void apply() {
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("title");
        createPostRequest.setBody("bodyyyyy");
        createPostRequest.setDocumentId("1");
        SavePostRequest response = postsRequestMapper.apply(createPostRequest);
        Assert.assertNotNull(response);
        Assert.assertTrue(response.getBody().equals(createPostRequest.getBody()));
        Assert.assertTrue(response.getTitle().equals(createPostRequest.getTitle()));
        Assert.assertTrue(response.getUserId().equals(createPostRequest.getDocumentId()));

    }
}