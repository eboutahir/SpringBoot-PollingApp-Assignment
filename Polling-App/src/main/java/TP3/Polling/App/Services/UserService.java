package TP3.Polling.App.Services;

import TP3.Polling.App.Models.Role;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Repositories.RoleRepository;
import TP3.Polling.App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService
{
    private final UserRepository userRepository;

    private RoleRepository roleRepository;
    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository)
    {
        this.userRepository=userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User>  getAllUser()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUsername(String name)
    {
        return userRepository.findByUsername(name);
    }
    public User creatUser(User user)
    {
        return userRepository.save(user);
    }

    public User updateUser(Long id,User user)
    {
        User existingUser=userRepository.findById(id).orElse(null);
        if(existingUser!=null)
        {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
           // existingUser.setVotes(user.getVotes());
            existingUser.setRoles(user.getRoles());
        }
        return null;
    }


    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }









}







