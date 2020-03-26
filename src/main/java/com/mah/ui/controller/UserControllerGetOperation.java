package com.mah.ui.controller;

import com.mah.ui.model.response.UserRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/api/example-for-get-operation/users")
// -> http://localhost:8080/api/example-for-get-operation/users
public class UserControllerGetOperation {

    private static final Logger LOGGER = LogManager.getLogger(UserControllerGetOperation.class);
    private static final String API_VERSION = "API version is: {}";
    private static final String FIRST_NAME = "Md Arif";
    private static final String LAST_NAME = "Hussain";
    private static final String EMAIL = "mdarifhussain385@gmail.com";

    @GetMapping(value = "/v1")
    public String getAllUsers(HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "getAllUsers was called thereby returning all existing users";
    }

    @GetMapping(value = "/v2")
    public String getAllUsersWithPagination(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize,
                                            @RequestParam(value = "sortBy", defaultValue = "desc", required = false) String sortBy, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "getUsersWithPagination was called with pageNo = " + pageNo + ", pageSize = " + pageSize + " and sortBy = " + sortBy;
    }

    //  Approach 1 uses Request Param
    @GetMapping(value = "/v3")
    public String getUserByIdUsingRequestParam(@RequestParam(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "getUserByIdUsingRequestParam was called with userId: " + userId;
    }

    //  Approach 2 uses Path Variable
    @GetMapping(value = "/v4/{userId}")
    public String getUserByIdUsingPathVariable(@PathVariable(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "getUserByIdUsingPathVariable was called with userId: " + userId;
    }

    @GetMapping(value = "/v5/{userId}")
    public UserRest getUserByIdWithDefaultResponseTypeAsJSON(@PathVariable(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return new UserRest(userId, FIRST_NAME, LAST_NAME, EMAIL);
    }

    @GetMapping(value = "/v6/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUserByIdWithResponseTypeAsJSONAndXML(@PathVariable(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return new UserRest(userId, FIRST_NAME, LAST_NAME, EMAIL);
    }

    @GetMapping(value = "/v7/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUserByIdWithResponseTypeAsJSONAndXMLUsingResponseEntity(@PathVariable(value = "userId") String userId, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return new ResponseEntity<>(new UserRest(userId, FIRST_NAME, LAST_NAME, EMAIL), HttpStatus.FOUND);
    }

}
