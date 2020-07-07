package uk.ac.qub.njoy.dissertation.recommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
