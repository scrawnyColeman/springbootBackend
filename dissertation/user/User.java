package uk.ac.qub.njoy.dissertation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uk.ac.qub.njoy.dissertation.userrole.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password_hash")
    private String password;

    @ManyToOne
    private UserRole UserRole;

    public User() {
    }
    public User(Long id) {
        this.id = id;
    }

    public User(String username, String email, String password, Long userRoleId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.UserRole = new UserRole(userRoleId);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return UserRole;
    }

    public void setUserRole(uk.ac.qub.njoy.dissertation.userrole.UserRole userRole) {
        UserRole = userRole;
    }

}
