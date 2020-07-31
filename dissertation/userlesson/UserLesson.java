package uk.ac.qub.njoy.dissertation.userlesson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.jpa.repository.Query;
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


    public UserLesson(boolean isCompleted, Long userId, Long lessonId) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
