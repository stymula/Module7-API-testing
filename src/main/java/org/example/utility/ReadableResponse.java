package org.example.utility;

import io.restassured.response.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadableResponse {
    private int statusCode;
    private String statusLine;
    private final Response response;

    public ReadableResponse(Response response) {
        this.response = response;
        this.statusCode = response.statusCode();
        this.statusLine = response.statusLine();
    }
}
