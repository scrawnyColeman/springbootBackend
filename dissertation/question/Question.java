package uk.ac.qub.njoy.dissertation.question;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "question")
    private String question;

    @Column(name="code_snippet")
    private String codeSnippet;


    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    public Question(Long id) {
        this.id = id;
    }

    public Question(String question, String codeSnippet, Long lessonId) {
        this.question = question;
        this.codeSnippet = codeSnippet;
        lesson = new Lesson(lessonId);
    }

    public Question() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
