package uk.ac.qub.njoy.dissertation.practical;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "practicals")
public class Practical {

    @Id
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "question")
    private String question;

    @Column(name = "code_snippet")
    private String codeSnippet;

    @Column(name = "hint")
    private String hint;

    @ManyToOne
    private Lesson lesson;

    public Practical(Long id, String title, String question, String codeSnippet, String hint, Long lessonId) {
        this.id = id;
        this.title = title;
        this.question = question;
        this.codeSnippet = codeSnippet;
        this.hint = hint;
        lesson = new Lesson(lessonId);
    }

    public Practical(Long id) {
        this.id = id;
    }

    public Practical() {
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

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
