package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping("/question/{id}/answers")
    public List<Answer> getAnswersToQuestion(@PathVariable(value = "id") Long id){
        return answerRepo.findByQuestionId(id);
    }
    @GetMapping("/questions/answers/lesson/{lessonId}")
    public List<Answer> getAnswerByLesson(@PathVariable Long lessonId){
        return answerRepo.findByLessonId(lessonId);
    }


    @PostMapping("/lessons/answers/new/{questionId}")
    public List<Answer> postLessonAnswers(@Validated @RequestBody List<Answer> answers, @PathVariable Long questionId){

        String answer;
        Boolean isCorrect;
        String responseMessage;
        Long answerTypeId = 1L;
        Answer newAnswer;
        List<Answer>newAnswers = new ArrayList<>();

        for(Answer a: answers){
                answer = a.getAnswer();
                isCorrect = a.getCorrect();
                responseMessage = a.getResponseMessage();
                newAnswer = new Answer(answer, isCorrect, responseMessage, answerTypeId, questionId);
                answerRepo.save(newAnswer);
                newAnswers.add(newAnswer);
        }
        return newAnswers;

    }



}
