package za.co.qdb.microservice.documents.api.adapter.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private String id;
	private String postId;
	private String name;
	private String body;
	private String email;

}
