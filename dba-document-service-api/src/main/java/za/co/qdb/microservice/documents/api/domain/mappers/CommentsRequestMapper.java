package za.co.qdb.microservice.documents.api.domain.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.qdb.documents.rest.model.CreateCommentRequest;
import za.co.qdb.microservice.documents.api.adapter.model.SaveCommentRequest;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CommentsRequestMapper implements Function<za.co.qdb.documents.rest.model.CreateCommentRequest, SaveCommentRequest> {

    @Override
    public SaveCommentRequest apply(CreateCommentRequest createCommentRequest) {
       return SaveCommentRequest.builder()
                .body(createCommentRequest.getBody())
                .email(createCommentRequest.getEmail())
                .name(createCommentRequest.getName())
                .build();

    }
}
