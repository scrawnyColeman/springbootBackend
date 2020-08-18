package uk.ac.qub.njoy.dissertation.userlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;
import uk.ac.qub.njoy.dissertation.lesson.Lesson;
import uk.ac.qub.njoy.dissertation.lesson.LessonRepository;
import uk.ac.qub.njoy.dissertation.user.User;
import uk.ac.qub.njoy.dissertation.user.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLessonController {

    @Autowired
    UserLessonRepository userLessonRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    LessonRepository lessonRepo;


    @GetMapping("/userlessons")
    public List<UserLesson> getAllUserLessons (){
      return userLessonRepo.findAll();
    };

    @GetMapping("/activeUsers/{lessonId}")
    public Long countActiveUsers(@PathVariable Long lessonId){
        return userLessonRepo.countByLessonId(lessonId);
    }
    /**
     * Get a single users lessons
     */
    @GetMapping("/user_lessons/{userId}")
    public List<UserLesson> getUncompletedLessonsByUser(@PathVariable Long userId) {
        return userLessonRepo.findByUserIdAndIsCompletedFalse(userId);
    }

    /**
     * Create a new user lesson
     */
    @PostMapping("/user/{userId}/lesson/{lessonId}")
    public UserLesson createUserLesson(@PathVariable(value = "userId") Long userId,
                           @PathVariable(value = "lessonId") Long lessonId) {

        UserLesson userLesson = userLessonRepo.findByLessonIdAndUserId(lessonId, userId);

        if(userLesson != null) {
            return userLesson;
        }

        User newUser = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Lesson lesson = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson", "id", lessonId));

        Long previousUsers = lesson.getActiveUsers();
        lesson.setActiveUsers(previousUsers+1);

        UserLesson newLesson = new UserLesson(false, newUser.getId(), lesson.getId());
        return userLessonRepo.save(newLesson);
    }
    @PutMapping("/lesson/complete/{lessonId}/{userId}")
    public UserLesson completeLesson(@PathVariable Long lessonId, @PathVariable Long userId){

        UserLesson userLesson = userLessonRepo.findByLessonIdAndUserId(lessonId, userId);

        userLesson.setCompleted(true);

        return userLessonRepo.save(userLesson);
    }
}
