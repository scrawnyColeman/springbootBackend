package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
