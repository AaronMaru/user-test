package com.example.usertest.service.user;

import com.example.usertest.constant.ResponseConstant;
import com.example.usertest.domain.User;
import com.example.usertest.repository.UserRP;
import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import com.example.usertest.service.BaseServiceIP;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserIP extends BaseServiceIP implements UserSV {

    @Autowired
    private UserRP userRP;

    @Override
    public StructureRS getUserById(Long id) {

        User user =  userRP.findById(id).orElse(null);


        return responseBody(HttpStatus.OK, ResponseConstant.SUCCESS, user);
    }

    @Override
    public StructureRS addUser(UserRQ userRQ) {
        User user = new User();
        BeanUtils.copyProperties(userRQ, user);
        userRP.save(user);

        return responseBody(HttpStatus.OK, ResponseConstant.SUCCESS);

    }
}
