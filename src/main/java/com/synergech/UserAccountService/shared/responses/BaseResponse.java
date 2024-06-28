package com.synergech.UserAccountService.shared.responses;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    private Object data;
    private String message;
    private String status;
    private Integer code;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> warnMessages;

    public BaseResponse(String message, String status, Integer code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}

