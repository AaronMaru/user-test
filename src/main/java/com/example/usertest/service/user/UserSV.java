package com.example.usertest.service.user;

import com.example.usertest.repository.UserRP;
import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import org.springframework.stereotype.Service;

@Service
public interface UserSV {

    StructureRS getUserById(Long id);

    StructureRS addUser(UserRQ userRQ);

}
