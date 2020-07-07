package uk.ac.qub.njoy.dissertation.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/njoy")
public class LessonController {

    @Autowired
    LessonRepository lessonRepo;

    /**
     * Get All Lessons
     */
    @GetMapping("/lessons")
    public List<Lesson> getAllLessons(){
        return lessonRepo.findAll();
    }

    /**
     * Get All Lessons
     * @return
     */
    @GetMapping("/lessons/{id}")
    public Optional<Lesson> getLessonById(@PathVariable Long id){
        return lessonRepo.findById(id);
    };
}
