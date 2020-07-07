package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

//    public List<Answer> findByQuestionId(Long questionId);

}
