package com.pramati.flashsale.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sudhirk
 *
 * Response class provides the format in which every response is send
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class Response {

    public Response(String error, String error_description, Object data) {
        this.error = error;
        this.error_description = error_description;
        this.data = data;
    }

    private String error;
    private String error_description;
    private Object data;
}