package za.co.qdb.microservice.documents.api.domain.service;

public interface CommentsService {
    za.co.qdb.documents.rest.model.Comment saveComments(za.co.qdb.documents.rest.model.CreateCommentRequest createCommentRequest);
}
