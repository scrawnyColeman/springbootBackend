package uk.ac.qub.njoy.dissertation.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.answers.Answer;
import uk.ac.qub.njoy.dissertation.answers.AnswerRepository;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;
import uk.ac.qub.njoy.dissertation.forumpost.ForumPost;
import uk.ac.qub.njoy.dissertation.forumpost.ForumPostRepository;
import uk.ac.qub.njoy.dissertation.language.Language;
import uk.ac.qub.njoy.dissertation.language.LanguageRepository;
import uk.ac.qub.njoy.dissertation.practical.Practical;
import uk.ac.qub.njoy.dissertation.practical.PracticalRepository;
import uk.ac.qub.njoy.dissertation.question.Question;
import uk.ac.qub.njoy.dissertation.question.QuestionRepository;
import uk.ac.qub.njoy.dissertation.solution.Solution;
import uk.ac.qub.njoy.dissertation.solution.SolutionRepository;
import uk.ac.qub.njoy.dissertation.user.User;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class LessonController {

    @Autowired
    LessonRepository lessonRepo;
    @Autowired
    ForumPostRepository forumPostRepo;
    @Autowired
    AnswerRepository answerRepo;
    @Autowired
    QuestionRepository questionRepo;
    @Autowired
    SolutionRepository solutionRepo;
    @Autowired
    PracticalRepository practicalRepo;
    @Autowired
    LanguageRepository languageRepo;
    /**
     * Get All Approved Lessons
     */
    @GetMapping("/lessons/approved")
    public List<Lesson> getAllApprovedLessons(){
        return lessonRepo.findByApprovedTrue();
    }

    /**
     * Get All Unapproved Lessons
     */
    @GetMapping("/lessons/unapproved")
    public List<Lesson> getAllUnapprovedLessons(){
        return lessonRepo.findByApprovedFalse();
    }

    @PutMapping("lessons/approve/{id}")
    public Lesson approveLesson(@PathVariable Long id){

        Lesson updatedLesson = lessonRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Lesson", "id", id));

        ForumPost newForumPost = new ForumPost("default", id);
        forumPostRepo.save(newForumPost);
        updatedLesson.setApproved(true);

        return lessonRepo.save(updatedLesson);
    }
    @DeleteMapping("lessons/delete/{id}")
    public void deleteLesson(@PathVariable Long id){

        Lesson lessonToDelete = lessonRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Lesson","id",id));

        List<Answer> answers = answerRepo.findByLessonId(id);
        List<Question> questions = questionRepo.findByLessonId(id);
        Practical practical = practicalRepo.findByLessonId(id);
        Solution solution = solutionRepo.findByPracticalId(practical.getId());

        for(Answer answer: answers){
            answerRepo.delete(answer);
        }
        for(Question question: questions){
            questionRepo.delete(question);
        }
        solutionRepo.delete(solution);
        practicalRepo.delete(practical);
        lessonRepo.delete(lessonToDelete);
    }


    /**
     * Get All Lessons
     * @return
     */
    @GetMapping("/lessons/{id}")
    public Lesson getLessonById(@PathVariable Long id){
        return lessonRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Lesson", "id", id));
    };

    @PostMapping("/lessons/new/{languageId}")
    public Lesson createNewLesson(@PathVariable Long languageId, @Validated @RequestBody Lesson lesson){

        Language language = languageRepo.findById(languageId)
                .orElseThrow(()-> new ResourceNotFoundException("Language","id",languageId));

        Lesson newLesson = new Lesson(
                0L,
                lesson.getTitle(),
                lesson.getDescription(),
                lesson.getTheory(),
                false,
                lesson.getYoutubeLink(),
                language.getId());



        return lessonRepo.save(newLesson);
    }

}
