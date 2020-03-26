package com.mah.ui.controller;

import com.mah.service.UserService;
import com.mah.shared.AnsiColorUtils;
import com.mah.ui.model.request.UpdateUserDetailsRequestModel;
import com.mah.ui.model.request.UserDetailsRequestModel;
import com.mah.ui.model.response.ResponseMessage;
import com.mah.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/users") // -> http://localhost:8080/api/users
public class UserControllerAllOperation {

    private final UserService userService;

    @Autowired
    public UserControllerAllOperation(UserService userService) {
        this.userService = userService;
    }

    //Note: when @RestControllerAdvice is enable then @Valid is not working, need to find out why
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody final UserDetailsRequestModel userDetailsRequestModel) {
        UserRest userRest = userService.createUser(userDetailsRequestModel);
        System.out.println(AnsiColorUtils.ANSI_GREEN + "userRest (createUser): " + AnsiColorUtils.ANSI_RESET);
        System.out.println(AnsiColorUtils.ANSI_GREEN + userRest + AnsiColorUtils.ANSI_RESET);
        return new ResponseEntity<UserRest>(userRest, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUserById(@PathVariable(value = "userId") String userId) {
        UserRest userRest = userService.getUserById(userId);
        if (userRest != null) {
            return new ResponseEntity<UserRest>(userRest, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("NO USER FOUND WITH USER_ID: " + userId), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllUsers() {
        Map<String, UserRest> allUsersMap = userService.getAllUsers();
        if (!allUsersMap.isEmpty()) {
            return new ResponseEntity<Map<String, UserRest>>(allUsersMap, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("NO USERS TO DISPLAY"), HttpStatus.OK);
        }
    }

    @PutMapping(value = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> updateUserById(@PathVariable(value = "userId") String userId, @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
        UserRest userRest = userService.updateUserById(userId, updateUserDetailsRequestModel);
        if (userRest != null) {
            return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("NO USER FOUND WITH USER_ID: " + userId), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseMessage> deleteUserById(@PathVariable(value = "userId") String userId) {
        boolean isDeleted = userService.deleteUserById(userId);
        if (isDeleted) {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("USER WITH USER_ID: '" + userId + "' DELETED SUCCESSFULLY"), HttpStatus.OK);
        } else {
            return new ResponseEntity<ResponseMessage>(new ResponseMessage("NO USER FOUND WITH USER_ID: " + userId), HttpStatus.NOT_FOUND);
        }
    }

}
