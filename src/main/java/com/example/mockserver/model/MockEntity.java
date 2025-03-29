package com.example.mockserver.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MockEntity {
    @Id
    private String id;
    private String uri;
    private String method;
    private String response;
    private int statusCode;
}
