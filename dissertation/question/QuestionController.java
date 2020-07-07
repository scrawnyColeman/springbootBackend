package uk.ac.qub.njoy.dissertation.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/njoy")
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
}
