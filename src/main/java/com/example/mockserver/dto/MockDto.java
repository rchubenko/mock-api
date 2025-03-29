package com.example.mockserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MockDto {
    private String uri;
    private String method;
    private String response;
    private int statusCode;
}
