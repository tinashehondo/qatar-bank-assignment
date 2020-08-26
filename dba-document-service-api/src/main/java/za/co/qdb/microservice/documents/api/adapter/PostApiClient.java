package za.co.qdb.microservice.documents.api.adapter;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import org.apache.http.HttpException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.qdb.microservice.documents.api.adapter.model.Comment;
import za.co.qdb.microservice.documents.api.adapter.model.Post;
import za.co.qdb.microservice.documents.api.adapter.model.SaveCommentRequest;
import za.co.qdb.microservice.documents.api.adapter.model.SavePostRequest;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(name = "posts", url = "https://jsonplaceholder.typicode.com",fallback = PostApiHystrixFallback.class)
public interface PostApiClient {

    @RequestLine("GET /posts")
    @Headers({"Accept: application/json;charset=UTF-8"})
    List<Post> getPosts();

    @RequestLine("GET /posts/{id}")
    @Headers({"Accept: application/json;charset=UTF-8"})
    Post getPostById(@RequestParam(value="id") String id);

    @RequestLine("GET /posts?userId={id}")
    @Headers({"Accept: application/json;charset=UTF-8"})
    Post getPostByUserId(@RequestParam(value="id") String id);

    @RequestLine("POST /posts")
    @Headers({"Accept: application/json;charset=UTF-8"})
    Post savePost(SavePostRequest savePostRequest);

    @RequestLine("POST /posts/{postId}/comments")
    @Headers({"Accept: application/json;charset=UTF-8"})
    Comment saveComments(@RequestBody SaveCommentRequest comment,@Param("postId") String postId);
}
