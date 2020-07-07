package uk.ac.qub.njoy.dissertation.answertype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerTypeRepository extends JpaRepository<AnswerType, Long> {
}
