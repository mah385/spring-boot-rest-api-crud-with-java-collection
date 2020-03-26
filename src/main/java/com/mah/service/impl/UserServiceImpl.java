package com.mah.service.impl;

import com.mah.service.UserService;
import com.mah.shared.AnsiColorUtils;
import com.mah.ui.model.request.UpdateUserDetailsRequestModel;
import com.mah.ui.model.request.UserDetailsRequestModel;
import com.mah.ui.model.response.UserRest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private static Map<String, UserRest> userRestMap = new HashMap<>();

    @PostConstruct
    public void initDataForUserRest() {
        String userId1 = UUID.randomUUID().toString();
        String userId2 = UUID.randomUUID().toString();
        userRestMap.put(userId1, new UserRest(userId1, "Md Arif", "Hussain", "mdarifhussain385@gmail.com"));
        userRestMap.put(userId2, new UserRest(userId2, "Venga", "Nathan", "venga@gmail.com"));
        System.out.println(AnsiColorUtils.ANSI_GREEN + "userRestMap: " + AnsiColorUtils.ANSI_RESET);
        System.out.println(AnsiColorUtils.ANSI_GREEN + userRestMap + AnsiColorUtils.ANSI_RESET);
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {
        String userId = UUID.randomUUID().toString();
        UserRest userRest = new UserRest(userId, userDetailsRequestModel.getFirstName(), userDetailsRequestModel.getLastName(), userDetailsRequestModel.getEmail());
        userRestMap.put(userId, userRest);
        return userRest;
    }

    @Override
    public UserRest getUserById(String userId) {
        UserRest userRest = null;
        if (userRestMap != null && userRestMap.containsKey(userId)) {
            userRest = userRestMap.get(userId);
        }
        return userRest;
    }

    @Override
    public Map<String, UserRest> getAllUsers() {
        return userRestMap;
    }

    @Override
    public UserRest updateUserById(String userId, UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
        UserRest userRest = null;
        if (userRestMap != null && userRestMap.containsKey(userId)) {
            userRest = userRestMap.get(userId);
            userRest.setFirstName(updateUserDetailsRequestModel.getFirstName());
            userRest.setLastName(updateUserDetailsRequestModel.getLastName());
            userRestMap.put(userId, userRest);
        }
        return userRest;
    }

    @Override
    public boolean deleteUserById(String userId) {
        if (userRestMap != null && userRestMap.containsKey(userId)) {
            userRestMap.remove(userId);
            return true;
        } else {
            return false;
        }
    }

}
