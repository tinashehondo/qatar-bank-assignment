package za.co.qdb.microservice.documents.api.adapter.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	private String id;
	private String title;
	private String body;
	private String userId;

}
