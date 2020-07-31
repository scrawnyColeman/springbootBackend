package uk.ac.qub.njoy.dissertation.practical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import java.util.List;

@RestController
@RequestMapping("/njoy")
@CrossOrigin(origins = "http://localhost:3000")
public class PracticalController {

    @Autowired
    PracticalRepository practicalRepo;

    /**
     * Get all practicals
     */
    @GetMapping("/practicals")
    public List<Practical> getAllPracticals(){
      return practicalRepo.findAll();
    };

    /**
     * Get all practicals
     */
    @GetMapping("/practicals/lesson/{id}")
    public Practical getPracticalByLessonId(@PathVariable Long id){
      return practicalRepo.findByLessonId(id);
    };

    @PostMapping("/lessons/practical/new/{lessonId}")
    public Long postNewPractical(@Validated @RequestBody Practical practical, @PathVariable Long lessonId){

        Practical newPractical = new Practical(
                practical.getTitle(),
                practical.getQuestion(),
                practical.getCodeSnippet(),
                practical.getHint(),
                lessonId
        );
        practicalRepo.save(newPractical);
        return newPractical.getId();
    }
}
