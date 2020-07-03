package uk.ac.qub.njoy.dissertation.forumpost;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "forum_posts")
public class ForumPost {

    @Id
    private Long id;

    private String title;

    private String question;

    @OneToOne
    private Lesson lesson;

    public ForumPost(Long id, Long lessonId) {
        this.id=id;
        lesson = new Lesson(lessonId);
    }
    public ForumPost(Long id) {
        this.id = id;
    }

    public ForumPost(Long id, String title, String question) {
        this.id = id;
        this.title = title;
        this.question = question;
        lesson = new Lesson(null);
    }

    public ForumPost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getLessonId() {
        return lesson.getId();
    }

    public void setLessonId(Long lessonId) {
        lesson.setId(lessonId);
    }
}
