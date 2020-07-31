package uk.ac.qub.njoy.dissertation.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.qub.njoy.dissertation.user.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

    @GetMapping("/njoy/authenticate")
    public String home(){
        return("hello");
    }
}
