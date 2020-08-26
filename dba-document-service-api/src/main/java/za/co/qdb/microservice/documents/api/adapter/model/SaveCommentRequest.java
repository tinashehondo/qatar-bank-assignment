package za.co.qdb.microservice.documents.api.adapter.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCommentRequest {
	private String name;
	private String body;
	private String email;

}
