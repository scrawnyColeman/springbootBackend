package uk.ac.qub.njoy.dissertation.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByApprovedTrue();
    List<Lesson> findByApprovedFalse();
}
