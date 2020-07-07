package uk.ac.qub.njoy.dissertation.userlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.qub.njoy.dissertation.exceptions.ResourceNotFoundException;
import uk.ac.qub.njoy.dissertation.user.User;

import java.util.List;


@RestController
@RequestMapping("/njoy")
public class UserLessonController {

    @Autowired
    UserLessonRepository userLessonRepo;

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
    public List<UserLesson> getLessonByUserId(@PathVariable Long userId) {
        return userLessonRepo.findByUserId(userId);
    }
}
