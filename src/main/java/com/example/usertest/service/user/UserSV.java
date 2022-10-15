package com.example.usertest.service.user;

import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import org.springframework.stereotype.Service;

@Service
public interface UserSV {

    /**
     * This method is for get User Record by Id
     * @param id
     * @return StructureRS
     */
    StructureRS getUserById(int id);

    /**
     * This method is for add User
     * @param userRQ
     * @return StructureRS
     */
    StructureRS addUser(UserRQ userRQ);

}
