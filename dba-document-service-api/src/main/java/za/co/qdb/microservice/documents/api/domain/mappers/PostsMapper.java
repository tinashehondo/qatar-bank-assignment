package za.co.qdb.microservice.documents.api.domain.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.qdb.documents.rest.model.CreatePostRequest;
import za.co.qdb.microservice.documents.api.adapter.model.Post;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class PostsMapper implements Function<Post, za.co.qdb.documents.rest.model.Post> {

    @Override
    public za.co.qdb.documents.rest.model.Post apply(Post post) {
        if (post ==null){
            return null;
        }
        za.co.qdb.documents.rest.model.Post postResponse = new za.co.qdb.documents.rest.model.Post();
        postResponse.setBody(post.getBody());
        postResponse.setDocumentId(post.getUserId());
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        return postResponse;
    }
}
