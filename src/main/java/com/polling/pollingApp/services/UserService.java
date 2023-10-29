package com.polling.pollingApp.services;

import com.polling.pollingApp.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserService {
    private User currentUser;
    public void login(String username) {
        currentUser = new User();
        currentUser.setUsername(username);
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
