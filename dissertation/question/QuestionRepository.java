package uk.ac.qub.njoy.dissertation.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAll();
    List<Question> findByLessonId(Long lessonId);
}
