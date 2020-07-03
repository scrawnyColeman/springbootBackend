package uk.ac.qub.njoy.dissertation.userlesson;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;
import uk.ac.qub.njoy.dissertation.user.User;

import javax.persistence.*;

@Entity
@Table(name = "user_lessons")
public class UserLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "is_completed")
    private boolean isCompleted;

    @ManyToOne
    private User user;

    @ManyToOne
    private Lesson lesson;

    public UserLesson(Long id, boolean isCompleted, Long userId, Long lessonId) {
        this.id = id;
        this.isCompleted = isCompleted;
        user = new User(userId);
        lesson = new Lesson(lessonId);
    }

    public UserLesson(Long id) {
        this.id = id;
    }

    public UserLesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Long getUserId() {
        return user.getId();
    }

    public void setUserId(Long userId) {
        user.setId(userId);
    }

    public Long getLessonId() {
        return lesson.getId();
    }

    public void setLessonId(Long lessonId) {
        lesson.setId(lessonId);
    }
}
