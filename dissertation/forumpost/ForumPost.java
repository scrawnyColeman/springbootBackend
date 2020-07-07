package uk.ac.qub.njoy.dissertation.forumpost;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "forum_posts")
public class ForumPost {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "question")
    private String question;

    @OneToOne
    private Lesson lesson;

    public ForumPost(Long id) {
        this.id = id;
    }

    /**
     * @param id
     * @param title
     * @param question
     */
    public ForumPost(Long id, String title, String question, Long lessonId) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.lesson = new Lesson(lessonId);

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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
