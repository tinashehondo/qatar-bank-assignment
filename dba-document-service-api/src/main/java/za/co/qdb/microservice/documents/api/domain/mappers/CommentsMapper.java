package za.co.qdb.microservice.documents.api.domain.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.qdb.microservice.documents.api.adapter.model.Comment;
import za.co.qdb.microservice.documents.api.adapter.model.Post;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CommentsMapper implements Function<Comment, za.co.qdb.documents.rest.model.Comment> {

    @Override
    public za.co.qdb.documents.rest.model.Comment apply(Comment comment) {
        if (comment == null){
            return null;
        }
        za.co.qdb.documents.rest.model.Comment commentResponse = new za.co.qdb.documents.rest.model.Comment();
        commentResponse.setBody(comment.getBody());
        commentResponse.setEmail(comment.getEmail());
        commentResponse.setId(comment.getId());
        commentResponse.setPostId(comment.getPostId());
        commentResponse.setName(comment.getName());
        return commentResponse;
    }
}
