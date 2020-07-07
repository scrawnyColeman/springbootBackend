package uk.ac.qub.njoy.dissertation.recommendation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepo;

    @GetMapping("/recommendations")
    public List<Recommendation> getAllRecommendations(){
        return recommendationRepo.findAll();
    }

}
