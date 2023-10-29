package TP3.Polling.App.Services;

import TP3.Polling.App.Models.Role;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Repositories.RoleRepository;
import TP3.Polling.App.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService
{
    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public List <Role> getAllRoles()
    {
        return roleRepository.findAll();

    }
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
    public Role getRoleByName(String Name) {
        return roleRepository.findByName(Name);
    }

    public Role updateRole(Long id, Role Role) {
        Role existingRole = roleRepository.findById(id).orElse(null);

        if (existingRole != null) {

            existingRole.setName(Role.getName());

            Role updatedRole= roleRepository.save(existingRole);
        }

        return null;
    }

    public void deleteRole(Long id) {

            roleRepository.deleteById(id);
    }

    public Role findRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public void assignRoleToUser(User user, Role role) {
        user.getRoles().add(role);
        // Sauvegardez l'utilisateur pour mettre à jour ses rôles dans la base de données.
        userRepository.save(user);
    }
}
