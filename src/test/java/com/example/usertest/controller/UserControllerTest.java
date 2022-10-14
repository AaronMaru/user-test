package com.example.usertest.controller;

import com.example.usertest.domain.User;
import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import com.example.usertest.service.user.UserSV;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.example.usertest.constant.ResponseConstant.SUCCESS;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    UserSV userSV;

    @Test
    public void addUserTest() throws Exception {

        //given
        StructureRS structureRS = new StructureRS();
        structureRS.setStatus(201);
        structureRS.setMessage(SUCCESS);

        UserRQ userRQ = new UserRQ();
        userRQ.setName("Sai Vichet");
        userRQ.setAge(30);
        userRQ.setCountry("Cambodia");
        userRQ.setHobby("Sport");

        given(userSV.addUser(userRQ)).willReturn(structureRS);

        //then
        MvcResult mvcResult = mockMvc.perform(post("/users").content(asJsonString(userRQ))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        System.out.println(mvcResult);
    }

    @Test
    public void addUserTestBadRequest() throws Exception {

        //given
        UserRQ userRQ = new UserRQ();
        userRQ.setAge(30);
        userRQ.setCountry("Cambodia");
        userRQ.setHobby("Sport");

        //then
        MvcResult mvcResult = mockMvc.perform(post("/users").content(asJsonString(userRQ))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("message", is("Name is mandatory"))).andReturn();

        System.out.println(mvcResult);
    }

    @Test
    public void getUserByIDTest() throws Exception {

        //given

        User user = new User();
        user.setId(1L);
        user.setName("Sai Vichet");
        user.setAge(30);
        user.setCountry("Cambodia");
        user.setHobby("Sport");

        StructureRS structureRS = new StructureRS();
        structureRS.setStatus(HttpStatus.OK.value());
        structureRS.setMessage(SUCCESS);
        structureRS.setData(user);

        given(userSV.getUserById(1L)).willReturn(structureRS);

        //then
        MvcResult mvcResult = mockMvc.perform(get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("message", is("res_succ"))).andReturn();

        System.out.println(mvcResult);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

