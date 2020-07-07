package uk.ac.qub.njoy.dissertation.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.qub.njoy.dissertation.user.User;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class SolutionController {

    @Autowired
    SolutionRepository solutionRepo;

    /**
     * Get ALL solutions
     */
    @GetMapping("/solutions")
    public List<Solution> getAllSolutions(){
        return solutionRepo.findAll();
    }
}
