package com.dominion.backend.utils;

import com.dominion.backend.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.net.Authenticator;

public class UserUtil {
    public static CustomUser getLoggedInUser() throws UserNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser user = (CustomUser) authentication.getPrincipal();
        if (user == null) {
        throw new UserNotFoundException();
        }
        return user;
    }
}
