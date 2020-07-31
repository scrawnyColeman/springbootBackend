package uk.ac.qub.njoy.dissertation.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepo;

    /**
     * GET ALL QUESTIONS
     * */
    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionRepo.findAll();
    };
    /**
     *
     * */
    @GetMapping("/questions/lesson/{lessonId}")
    public List<Question> getAllQuestionsByLesson(@PathVariable Long lessonId){
        return questionRepo.findByLessonId(lessonId);
    };

    @PostMapping("lessons/questions/new/{lessonId}")
    public List<String> postQuestions(@PathVariable Long lessonId,
                                 @Validated @RequestBody List<Question> questions){
        String question;
        Question newQuestion;
        List<String> newQuestions = new ArrayList<>();

        for(Question q: questions){
            question = q.getQuestion();
            newQuestion = new Question(question, null, lessonId);
            questionRepo.save(newQuestion);
            newQuestions.add(newQuestion.getQuestion()+":id:"+newQuestion.getId());
        }
        return newQuestions;

    }

}
