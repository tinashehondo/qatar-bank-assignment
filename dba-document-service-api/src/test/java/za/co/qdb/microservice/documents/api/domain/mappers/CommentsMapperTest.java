package za.co.qdb.microservice.documents.api.domain.mappers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.microservice.documents.api.adapter.model.Comment;
import za.co.qdb.microservice.documents.api.domain.model.Document;

@ExtendWith(SpringExtension.class)
class CommentsMapperTest {

    @InjectMocks
    private CommentsMapper commentsMapper;

    @Test
    void apply() {
        Comment commentSource =
                Comment.builder()
                        .body("asfsfasfafaff")
                .email("email@test.com")
                .id("101")
                .name("name")
                .postId("1")
                .build();
        za.co.qdb.documents.rest.model.Comment commentOutput = commentsMapper.apply(commentSource);
        Assert.assertNotNull(commentOutput);
        Assert.assertTrue(commentOutput.getEmail().equals(commentSource.getEmail()));
        Assert.assertTrue(commentOutput.getId().equals(commentSource.getId()));
        Assert.assertTrue(commentOutput.getName().equals(commentSource.getName()));
        Assert.assertTrue(commentOutput.getPostId().equals(commentSource.getPostId()));
    }
}