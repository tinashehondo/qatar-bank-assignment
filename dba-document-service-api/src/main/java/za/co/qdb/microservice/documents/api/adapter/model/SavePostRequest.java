package za.co.qdb.microservice.documents.api.adapter.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePostRequest {
	private String title;
	private String body;
	private String userId;

}
