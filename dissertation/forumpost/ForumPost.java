package uk.ac.qub.njoy.dissertation.forumpost;

import com.sun.istack.Nullable;
import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "forum_posts")
public class ForumPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "question")
    @Nullable
    private String question;

    @OneToOne
    @Nullable
    private Lesson lesson;


    /**
     * @param title
     * @param question
     */
    public ForumPost(String title, String question, Long lessonId) {
        this.title = title;
        this.question = question;
        this.lesson = new Lesson(lessonId);
    }

    public ForumPost(String title, String question) {
        this.title = title;
        this.question = question;
    }

    public ForumPost(String title, Long lessonId) {
        this.title = null;
        this.question = null;
        this.lesson= new Lesson(lessonId);
    }

    public ForumPost(Long id) {
        this.id = id;
    }


    public ForumPost(){}


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
