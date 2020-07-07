package uk.ac.qub.njoy.dissertation.userrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.qub.njoy.dissertation.user.User;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class UserRoleController {

    @Autowired
    UserRoleRepository userRoleRepo;

    /**
     * GET USER ROLES
     */
    @GetMapping("/userroles")
    public List<UserRole> getAllUsers(){
        return userRoleRepo.findAll();
    }
}
