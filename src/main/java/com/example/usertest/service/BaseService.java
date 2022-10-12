package com.example.usertest.service;

import com.example.usertest.response.PagingRS;
import com.example.usertest.response.StructureRS;
import org.springframework.http.HttpStatus;

public interface BaseService {

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @return
     */
    StructureRS responseBodyWithSuccessMessage();

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @return
     */
    StructureRS responseBody(HttpStatus status);

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @param message
     * @return
     */
    StructureRS responseBody(HttpStatus status, String message);

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @param message
     * @param data
     * @return
     */
    StructureRS responseBody(HttpStatus status, String message, Object data);

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @param message
     * @param data
     * @param paging
     * @return
     */
    StructureRS responseBody(HttpStatus status, String message, Object data, PagingRS paging);

}
