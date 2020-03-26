package com.mah.ui.controller;

import com.mah.shared.AnsiColorUtils;
import com.mah.ui.model.request.UserDetailsRequestModel;
import com.mah.ui.model.response.UserRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/example-for-post-operation/users")
// -> http://localhost:8080/api/example-for-post-operation/users
public class UserControllerPostOperation {

    private static final Logger LOGGER = LogManager.getLogger(UserControllerPostOperation.class);
    private static final String API_VERSION = "API version is: {}";

    @PostMapping(value = "/v1")
    public String createUser(HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        return "createUser was called thereby creating a new user";
    }

    @PostMapping(value = "/v2")
    public UserRest createUserWithDefaultRequestAndResponseTypeAsJSONAndWithoutValidation(@RequestBody UserDetailsRequestModel userDetailsRequestModel, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        UserRest userRest = new UserRest(UUID.randomUUID().toString(), userDetailsRequestModel.getFirstName(), userDetailsRequestModel.getLastName(), userDetailsRequestModel.getEmail());
        System.out.println(AnsiColorUtils.ANSI_YELLOW + "userRest: " + AnsiColorUtils.ANSI_RESET);
        System.out.println(AnsiColorUtils.ANSI_YELLOW + userRest + AnsiColorUtils.ANSI_RESET);
        return userRest;
    }

    @PostMapping(value = "/v3", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest createUserWithRequestAndResponseTypeAsJSONAndXMLAndWithValidation(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        UserRest userRest = new UserRest(UUID.randomUUID().toString(), userDetailsRequestModel.getFirstName(), userDetailsRequestModel.getLastName(), userDetailsRequestModel.getEmail());
        System.out.println(AnsiColorUtils.ANSI_YELLOW + "userRest: " + AnsiColorUtils.ANSI_RESET);
        System.out.println(AnsiColorUtils.ANSI_YELLOW + userRest + AnsiColorUtils.ANSI_RESET);
        return userRest;
    }

    @PostMapping(value = "/v4", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUserWithRequestAndResponseTypeAsJSONAndXMLAndWithValidationUsingResponseEntity(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel, HttpServletRequest httpServletRequest) {
        LOGGER.info(API_VERSION, httpServletRequest.getRequestURI());
        UserRest userRest = new UserRest(UUID.randomUUID().toString(), userDetailsRequestModel.getFirstName(), userDetailsRequestModel.getLastName(), userDetailsRequestModel.getEmail());
        System.out.println(AnsiColorUtils.ANSI_YELLOW + "userRest: " + AnsiColorUtils.ANSI_RESET);
        System.out.println(AnsiColorUtils.ANSI_YELLOW + userRest + AnsiColorUtils.ANSI_RESET);
        return new ResponseEntity<>(userRest, HttpStatus.CREATED);
    }

}
