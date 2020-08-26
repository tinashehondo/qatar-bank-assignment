package za.co.qdb.microservice.documents.api.domain.mappers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.microservice.documents.api.adapter.model.Post;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PostsMapperTest {

    @InjectMocks
    private PostsMapper postsMapper;

    @Test
    void apply() {
        Post postSource = Post.builder()
                .body("afafafasfafa")
                .id("1")
                .title("title")
                .userId("101")
                .build();
        za.co.qdb.documents.rest.model.Post postResponse = postsMapper.apply(postSource);
        Assert.assertNotNull(postResponse);
        Assert.assertTrue(postResponse.getBody().equals(postSource.getBody()));
        Assert.assertTrue(postResponse.getId().equals(postSource.getId()));
        Assert.assertTrue(postResponse.getTitle().equals(postSource.getTitle()));
        Assert.assertTrue(postResponse.getDocumentId().equals(postSource.getUserId()));
    }
}