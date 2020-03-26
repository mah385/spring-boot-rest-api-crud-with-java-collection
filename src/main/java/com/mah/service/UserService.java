package com.mah.service;

import com.mah.ui.model.request.UpdateUserDetailsRequestModel;
import com.mah.ui.model.request.UserDetailsRequestModel;
import com.mah.ui.model.response.UserRest;

import java.util.Map;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);

    UserRest getUserById(String userId);

    Map<String, UserRest> getAllUsers();

    UserRest updateUserById(String userId, UpdateUserDetailsRequestModel updateUserDetailsRequestModel);

    boolean deleteUserById(String userId);
}
