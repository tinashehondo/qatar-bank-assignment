package za.co.qdb.microservice.documents.api.domain.service;

public interface PostsService {
    za.co.qdb.documents.rest.model.Post savePosts(za.co.qdb.documents.rest.model.CreatePostRequest document);
    za.co.qdb.documents.rest.model.Post getPostByDocumentId(String documentId);
}
