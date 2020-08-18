package uk.ac.qub.njoy.dissertation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;
import uk.ac.qub.njoy.dissertation.userrole.UserRole;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
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
     * Create a new user
     */
    @PostMapping("/user/")
    public User createUser(@Validated @RequestBody User user) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        User newUser = new User(user.getUsername(), user.getEmail(), enc.encode(user.getPassword()), 1L);
        return userRepo.save(newUser);
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
     * Find by username
     */
     @GetMapping("/users/{username}/user")
     public User getUserByName(@PathVariable String username) {
         return userRepo.findByUsername(username);
     }
     /**
     * Find by username or email
     */
     @GetMapping("/user/{username}/{email}")
     public List<User> checkIfNewInformationInUse(@PathVariable String username, @PathVariable String email) {
         List<User>users = new ArrayList<>();
         users.add(userRepo.findByUsername(username));
         users.add(userRepo.findByEmail(email));
         return users;

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
     * Update user role
     */
     @PutMapping("/users/{userId}/roles/{userRoleId}")
     public User updateUserRole(@PathVariable (value="userId")  Long userId,
                            @PathVariable (value="userRoleId") Long userRoleId) {

         User user = userRepo.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

         user.setUserRole(new UserRole(userRoleId));

         User updatedUser = userRepo.save(user);
         return updatedUser;
     }
     /**
     * Update user info
     */
     @PutMapping("/users/{userId}/username/{username}/email/{email}")
     public User updateInfo(@PathVariable (value="userId")  Long userId,
                            @PathVariable (value="email") String email,
                            @PathVariable (value="username") String username) {

         User user = userRepo.findById(userId)
                 .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

         user.setEmail(email);
         user.setUsername(username);

         User updatedUser = userRepo.save(user);

         return updatedUser;
     }



}
