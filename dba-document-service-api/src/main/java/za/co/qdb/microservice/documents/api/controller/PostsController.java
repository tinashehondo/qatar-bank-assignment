
package za.co.qdb.microservice.documents.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import za.co.qdb.documents.rest.model.Document;
import za.co.qdb.documents.rest.model.Post;
import za.co.qdb.microservice.documents.api.domain.service.DocumentService;
import za.co.qdb.microservice.documents.api.domain.service.PostsService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = CorsConfiguration.ALL)
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PostsController implements za.co.qdb.documents.rest.api.PostsApi {

    @Autowired
    private PostsService postsService;

    @Override
    public ResponseEntity<Post> getPostByDocumentId(String documentId) {
        return ResponseEntity.status(HttpStatus.OK).body(postsService.getPostByDocumentId(documentId));
    }

    @Override
    public ResponseEntity<Post> savePost(@Valid za.co.qdb.documents.rest.model.CreatePostRequest postRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postsService.savePosts(postRequest));
    }

}
