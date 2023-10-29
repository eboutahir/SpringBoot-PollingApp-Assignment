package TP3.Polling.App.Controllers;

import TP3.Polling.App.Models.Role;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Security.AuthService;
import TP3.Polling.App.Services.RoleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;
    private final AuthService authService;
    @Autowired
    private Map<String, User> sessions ;

    @Autowired
    public RoleController(RoleService roleService, AuthService authService) {
        this.roleService = roleService;
        this.authService = authService;
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{roleId}")
    public Role getRoleById(@PathVariable Long roleId) {
        return roleService.getRoleById(roleId);
    }

    @GetMapping("/name/{roleName}")
    public Role getRoleByName(@PathVariable String roleName) {
        return roleService.getRoleByName(roleName);
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role,@RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            roleService.createRole(role);
            return ResponseEntity.ok("Rôle créé avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<String> updateRole(@PathVariable Long roleId, @RequestBody Role updatedRole, @RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            roleService.updateRole(roleId, updatedRole);
            return ResponseEntity.ok("Rôle modifié avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable Long roleId, @RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            roleService.deleteRole(roleId);
            return ResponseEntity.ok("Rôle supprimé avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }
}

