package uk.ac.qub.njoy.dissertation.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.user.User;

import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
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

    /**
     * Get ALL solutions
     */
    @GetMapping("/solutions/practical/{id}")
    public Solution getSolutionsByLessonId(@PathVariable(value = "id") Long id){
        return solutionRepo.findByPracticalId(id);
    }

    @PostMapping("/lessons/solutions/new/{practicalId}")
    public Solution postSolutionToPractical(@PathVariable Long practicalId, @Validated @RequestBody Solution solution){

        Solution newSolution = new Solution(
                solution.getCodeSnippet(),
                solution.getExplanation(),
                practicalId
        );
        return solutionRepo.save(newSolution);
    }
}
