
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
import za.co.qdb.documents.rest.model.Comment;
import za.co.qdb.microservice.documents.api.domain.service.CommentsService;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin(origins = CorsConfiguration.ALL)
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CommentsController implements za.co.qdb.documents.rest.api.CommentsApi {

    @Autowired
    private CommentsService commentsService;

    @Override
    public ResponseEntity<Comment> saveComment(@Valid za.co.qdb.documents.rest.model.CreateCommentRequest createCommentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentsService.saveComments(createCommentRequest));
    }
}
