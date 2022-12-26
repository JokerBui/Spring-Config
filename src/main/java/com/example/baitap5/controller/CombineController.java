package com.example.baitap5.controller;

import com.example.baitap5.model.Response;
import com.example.baitap5.service.SachService;
import com.example.baitap5.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
public class CombineController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CombineController.class);
    @Autowired
    SachService sachService;
    @Autowired
    UserService userService;
    @GetMapping("/all")
    public Response getResponse(){
        LOGGER.info("Thong Tin Khach Hang");
        Response response = new Response();
        response.setUsers(userService.listAll());
        response.setSaches(sachService.listAll());
        return response;

    }
}
