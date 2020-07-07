package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class AnswerController {

    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerRepository answerRepo;
    /**
     * Get all answers
     */
    @GetMapping("/answers")
    public List<Answer> getAllAnswers(){
        return answerRepo.findAll();
    }
//    @GetMapping("/question/{id}/answers")
//    public List<Answer> getAnswersToQuestion(@PathVariable(value = "id") Long id){
//        return answerService.getAllAnswers(id);
//    }

}
