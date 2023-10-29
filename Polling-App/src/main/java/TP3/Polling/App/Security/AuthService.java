package TP3.Polling.App.Security;

import TP3.Polling.App.Models.Role;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    private final UserService userService;
    @Autowired
    private HttpSession httpSession;

    private Map<String, User> sessions ;
    public AuthService(UserService userService) {
        this.userService = userService;
    }


    public boolean authenticate(String username, String password) {
        User user = userService.findByUsername(username);
        System.out.println("usrname"+userService.findByUsername(username));
        if (user != null && user.getPassword().equals(password)) {

            httpSession.setAttribute("user", user);
            return true;
        }

        return false;
    }

    public void logout() {
        // Supprimer la session utilisateur
        httpSession.removeAttribute("user");
    }



    public boolean isUserAdmin(String sessionId, Map<String, User> sessions) {
        User user = sessions.get(sessionId);

        if (user != null && user.getRoles() != null) {
            if( user.getRoles().stream().anyMatch(role -> "Admin".equals(role.getName())))
            {
                return true;
            }
            else {
                return false;
            }
        }
        else
            return false;

    }

}
