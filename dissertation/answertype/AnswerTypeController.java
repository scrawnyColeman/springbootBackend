package uk.ac.qub.njoy.dissertation.answertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/njoy")
public class AnswerTypeController {

    @Autowired
    AnswerTypeRepository answerTypeRepo;

    /**
     * Get all answer types
     */
    @GetMapping("/answertypes")
    public List<AnswerType> getAllAnswerTypes(){
        return answerTypeRepo.findAll();
    }
}
