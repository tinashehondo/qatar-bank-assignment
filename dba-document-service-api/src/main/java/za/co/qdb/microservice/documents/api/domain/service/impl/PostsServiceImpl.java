package za.co.qdb.microservice.documents.api.domain.service.impl;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import za.co.qdb.documents.rest.model.CreatePostRequest;
import za.co.qdb.documents.rest.model.Post;
import za.co.qdb.microservice.documents.api.adapter.PostApiClient;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;
import za.co.qdb.microservice.documents.api.domain.mappers.DocumentMapper;
import za.co.qdb.microservice.documents.api.domain.mappers.PostsMapper;
import za.co.qdb.microservice.documents.api.domain.mappers.PostsRequestMapper;
import za.co.qdb.microservice.documents.api.domain.model.Document;
import za.co.qdb.microservice.documents.api.domain.repository.DocumentRepository;
import za.co.qdb.microservice.documents.api.domain.service.DocumentService;
import za.co.qdb.microservice.documents.api.domain.service.PostsService;

import java.util.*;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsMapper postsMapper;

    @Autowired
    private PostsRequestMapper postsRequestMapper;

    @Autowired
    private PostApiClient postApiClient;

    @Override
    public Post savePosts(CreatePostRequest createPostRequest) {
        SavePostRequest savePostRequest = postsRequestMapper.apply(createPostRequest);
        za.co.qdb.microservice.documents.api.adapter.model.Post postResponse = postApiClient.savePost(savePostRequest);
        if (postResponse ==null){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Down stream service, post api is down at the moment");
        }
        return postsMapper.apply(postResponse);
    }

    @Override
    public Post getPostByDocumentId(String documentId) {
        Map<String, String> parameters = new LinkedHashMap<>();
        parameters.put("userId", documentId);
        za.co.qdb.microservice.documents.api.adapter.model.Post postResponse = postApiClient.getPostById(documentId);
        if (postResponse == null){
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Error calling external posts service");
        }
        return postsMapper.apply(postResponse);
    }
}
