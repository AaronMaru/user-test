package com.example.usertest.service;

import com.example.usertest.constant.ResponseConstant;
import com.example.usertest.response.PagingRS;
import com.example.usertest.response.StructureRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceIP implements BaseService {

    @Autowired
    private StructureRS structureRS;

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @return
     */
    @Override
    public StructureRS responseBodyWithSuccessMessage() {
        return responseBody(HttpStatus.OK, ResponseConstant.SUCCESS, null, null);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @return
     */
    @Override
    public StructureRS responseBody(HttpStatus status) {
        return responseBody(status, null, null, null);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     * response body follow base structure response
     * -----------------------------------------------------------------------------------------------------------------
     *
     * @param status
     * @param message
     * @return
     */
    @Override
    public StructureRS responseBody(HttpStatus status, String message) {
        return responseBody(status, message, null, null);
    }

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
    @Override
    public StructureRS responseBody(HttpStatus status, String message, Object data) {
        return responseBody(status, message, data, null);
    }

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
    public StructureRS responseBody(HttpStatus status, String message, Object data, PagingRS paging) {
        structureRS.setStatus(status.value());
        structureRS.setMessage(message);
        structureRS.setData(data);
        structureRS.setPaging(paging);

        return structureRS;
    }
}
