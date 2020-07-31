package uk.ac.qub.njoy.dissertation.answers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByQuestionId(Long questionId);


    /*
    SELECT * FROM answers INNER JOIN questions ON
        answers.question_id = questions.id
        INNER JOIN lessons ON
        questions.lesson_id = lessons.id
        WHERE lessons.id = 1


        from answers a inner join fetch r.comments where r.lessonId = :id
     */
    @Query(nativeQuery = true, value = "SELECT * FROM answers a " +
            "INNER JOIN questions q ON " +
            "a.question_id = q.id " +
            "INNER JOIN lessons l ON " +
            "q.lesson_id = l.id " +
            "WHERE l.id = :id")
    List<Answer> findByLessonId(@Param("id") Long lessonId);
}
