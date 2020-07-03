package uk.ac.qub.njoy.dissertation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class UserController {

    @Autowired
    UserRepository userRepo;

    /**
     * Get All Users
     */
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    /**
     * Get User By Type
     */
//    @GetMapping("/users/types/{id}")
//    public List<User> getUsersByRole(@PathVariable(value = "id") Long roleId){
//        return userRepo.findByUserRoleId(roleId);
//    }

    /**
     * Create a new user
     */
    @PostMapping("/users")
    public User createUser(@Validated @RequestBody User user) {
        return userRepo.save(user);
    }
     /**
     * Get a single user
     */
     @GetMapping("/users/{id}")
     public User getUserById(@PathVariable(value = "id") Long userId) {
         return userRepo.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
     }
     /**
     * Update a user
     */
     @PutMapping("/users/{id}")
     public User updateUser(@PathVariable(value = "id") Long userId,
                            @Validated @RequestBody User userInfo) {

         User user = userRepo.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

         user.setUsername(userInfo.getUsername());
         user.setEmail(userInfo.getEmail());

         User updatedUser = userRepo.save(user);
         return userInfo;
     }
     /**
     * Delete a user
     */
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        userRepo.delete(user);
        return ResponseEntity.ok().build();

    }



}
