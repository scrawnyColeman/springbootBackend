package uk.ac.qub.njoy.dissertation.practical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/njoy")
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
}
