package com.mah.ui.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api/example-for-delete-operation/users")
// -> http://localhost:8080/api/example-for-delete-operation/users
public class UserControllerDeleteOperation {

    private static final Logger LOGGER = LogManager.getLogger(UserControllerDeleteOperation.class);
    private static final String API_VERSION = "API version is: {}";

    //  Approach 1 uses Request Param
    @PutMapping(value = "/v1")
    public String deleteUserByIdUsingRequestParam(@RequestParam(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "deleteUserByIdUsingRequestParam was called thereby deleting an existing user with userId: " + userId;
    }

    //  Approach 2 uses Path Variable
    @PutMapping(value = "/v2/{userId}")
    public String deleteUserByIdUsingPathVariable(@PathVariable(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "deleteUserByIdUsingPathVariable was called thereby deleting an existing user with userId: " + userId;
    }

}
