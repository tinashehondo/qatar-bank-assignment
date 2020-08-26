package za.co.qdb.microservice.documents.api.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import za.co.qdb.documents.rest.model.Comment;
import za.co.qdb.documents.rest.model.CreateCommentRequest;
import za.co.qdb.microservice.documents.api.adapter.PostApiClient;
import za.co.qdb.microservice.documents.api.adapter.model.SaveCommentRequest;
import za.co.qdb.microservice.documents.api.domain.mappers.CommentsMapper;
import za.co.qdb.microservice.documents.api.domain.mappers.CommentsRequestMapper;
import za.co.qdb.microservice.documents.api.domain.service.CommentsService;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRequestMapper commentsRequestMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private PostApiClient postApiClient;

    @Override
    public Comment saveComments(CreateCommentRequest createCommentRequest) {
        SaveCommentRequest savePostRequest = commentsRequestMapper.apply(createCommentRequest);
        za.co.qdb.microservice.documents.api.adapter.model.Comment postResponse = postApiClient.saveComments(savePostRequest,createCommentRequest.getPostId());
       if (postResponse ==null){
           throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Down stream service, post api is down at the moment");
       }
        return commentsMapper.apply(postResponse);
    }
}
