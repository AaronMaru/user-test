package com.example.usertest.service.user;

import com.example.usertest.constant.ResponseConstant;
import com.example.usertest.domain.User;
import com.example.usertest.exception.httpstatus.BadRequestException;
import com.example.usertest.repository.UserRP;
import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import com.example.usertest.service.BaseServiceIP;
import com.example.usertest.service.SequenceGeneratorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.example.usertest.domain.User.SEQUENCE_NAME;

@Service
public class UserIP extends BaseServiceIP implements UserSV {

    @Value("${country.allow}")
    private String countryAllow;

    @Autowired
    private UserRP userRP;

    @Autowired
    private SequenceGeneratorService service;

    @Override
    public StructureRS getUserById(int id) {

        User user = userRP.findById(id).orElse(null);

        return responseBody(HttpStatus.OK, ResponseConstant.SUCCESS, user);

    }

    @Override
    public StructureRS addUser(UserRQ userRQ) {

        if (!userRQ.getCountry().equalsIgnoreCase(countryAllow)) {
            throw new BadRequestException("Only user from french allow to create account", null);
        }

        User user = new User();
        BeanUtils.copyProperties(userRQ, user);
        user.setId(service.getSequenceNumber(SEQUENCE_NAME));
        userRP.save(user);

        return responseBody(HttpStatus.CREATED, ResponseConstant.SUCCESS);

    }
}
