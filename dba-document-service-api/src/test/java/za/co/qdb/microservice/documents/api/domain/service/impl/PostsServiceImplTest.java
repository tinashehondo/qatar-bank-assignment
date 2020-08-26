package za.co.qdb.microservice.documents.api.domain.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.qdb.documents.rest.model.CreatePostRequest;
import za.co.qdb.documents.rest.model.Post;
import za.co.qdb.microservice.documents.api.adapter.PostApiClient;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;
import za.co.qdb.microservice.documents.api.domain.mappers.PostsMapper;
import za.co.qdb.microservice.documents.api.domain.mappers.PostsRequestMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PostsServiceImplTest {

    @Mock
    private PostsMapper postsMapper;

    @Mock
    private PostsRequestMapper postsRequestMapper;

    @Mock
    private PostApiClient postApiClient;

    @InjectMocks
    private PostsServiceImpl postsService;

    @Test
    void savePosts() {
        when(postsRequestMapper.apply(any())).thenReturn(new SavePostRequest());
        za.co.qdb.microservice.documents.api.adapter.model.Post post= new za.co.qdb.microservice.documents.api.adapter.model.Post();
        post.setBody("testbody");
        when(postApiClient.savePost(any(SavePostRequest.class))).thenReturn(post);
        when(postsMapper.apply(any())).thenReturn(new Post());
        Post response = postsService.savePosts(new CreatePostRequest());
        Assert.assertNotNull(response);
        verify(postApiClient,times(1)).savePost(any(SavePostRequest.class));
    }

    @Test
    void getPostByDocumentId() {
        za.co.qdb.microservice.documents.api.adapter.model.Post post= new za.co.qdb.microservice.documents.api.adapter.model.Post();
        post.setBody("testbody");
        when(postApiClient.getPostById(any())).thenReturn(post);
        when(postsMapper.apply(any())).thenReturn(new Post());
        Post response = postsService.getPostByDocumentId("1");
        Assert.assertNotNull(response);
        verify(postApiClient,times(1)).getPostById(any());
    }
}