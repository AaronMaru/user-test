package com.example.usertest.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Data
@Component
public class StructureRS {
    private int status = HttpStatus.OK.value();
    private String message = "res_suc";
    private Object data;
    private PagingRS paging;
}
