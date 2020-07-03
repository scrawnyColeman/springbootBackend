package uk.ac.qub.njoy.dissertation.recommendation;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "recommended_prerequisites")
public class RecommendedLesson {
    @Id
    private Long id;

    @ManyToOne
    @MapsId("lesson_id")
    @JoinColumn(name = "lesson_id")
    private Lesson parentLesson;

    @ManyToOne
    @MapsId("recommended_lesson_id")
    @JoinColumn(name = "recommended_lesson_id")
    private Lesson recommendedLesson;

    public RecommendedLesson(Long id, Long parentLessonId, Long recommendedLessonId) {
        this.id = id;
        parentLesson = new Lesson(parentLessonId);
        recommendedLesson = new Lesson(recommendedLessonId);
    }

    public RecommendedLesson(Long id) {
        this.id = id;
    }

    public RecommendedLesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lesson getParentLesson() {
        return parentLesson;
    }

    public void setParentLesson(Lesson parentLesson) {
        this.parentLesson = parentLesson;
    }

    public Lesson getRecommendedLesson() {
        return recommendedLesson;
    }

    public void setRecommendedLesson(Lesson recommendedLesson) {
        this.recommendedLesson = recommendedLesson;
    }
}
