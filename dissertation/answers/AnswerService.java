package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepo;

//    public List<Answer> getAllAnswers(Long questionId){
//        List<Answer> answers = new ArrayList<Answer>();
//        answerRepo.findByQuestionId(questionId)
//                .forEach(answers::add);
//        return answers;
//    }
@PostMapping("/questions/answers/new/{lessonId}")
public List<Answer> postNewQuiz(@PathVariable Long questionId,
                                @Validated @RequestBody List<Answer>answers){
    return answers;
}
}
