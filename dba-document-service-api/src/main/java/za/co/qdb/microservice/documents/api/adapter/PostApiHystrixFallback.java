package za.co.qdb.microservice.documents.api.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import za.co.qdb.microservice.documents.api.adapter.model.Comment;
import za.co.qdb.microservice.documents.api.adapter.model.Post;
import za.co.qdb.microservice.documents.api.adapter.model.SaveCommentRequest;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;

import java.util.List;

@Component
@Slf4j
public class PostApiHystrixFallback implements PostApiClient {

    @Override
    public List<Post> getPosts() {
        log.debug("down stream posts api service down for getPosts request");
        return null;
    }

    @Override
    public Post getPostById(String id) {
        log.debug("down stream posts api service down for getPostById request with id {}",id);
        return null;
    }

    @Override
    public Post getPostByUserId( String id) {
        log.debug("down stream posts api service down for getPostByUserId request with id  {}",id);
        return null;
    }

    @Override
    public Post savePost(SavePostRequest savePostRequest)  {
        log.debug("down stream posts api service down for savePost request {}",savePostRequest);
        return null;
    }

    @Override
    public Comment saveComments(SaveCommentRequest saveCommentRequest,String postId ) {
        log.debug("down stream posts api service down for request {}",saveCommentRequest);
        return null;
    }
}
