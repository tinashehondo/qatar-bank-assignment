package za.co.qdb.microservice.documents.api.domain.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import za.co.qdb.documents.rest.model.CreatePostRequest;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;
import za.co.qdb.microservice.documents.api.domain.model.Document;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class PostsRequestMapper implements Function< za.co.qdb.documents.rest.model.CreatePostRequest,SavePostRequest> {

    @Override
    public SavePostRequest apply(CreatePostRequest createPostRequest) {
        return SavePostRequest
                .builder()
                .body(createPostRequest.getBody())
                .title(createPostRequest.getTitle())
                .userId(createPostRequest.getDocumentId())
                .build();
    }
}
