package uk.ac.qub.njoy.dissertation.userlesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLessonRepository extends JpaRepository<UserLesson, Long> {

    List<UserLesson> findByUserIdAndIsCompletedFalse(Long userId);

    Long countByLessonId(Long lessonId);

}
