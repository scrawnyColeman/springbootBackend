package uk.ac.qub.njoy.dissertation.question;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, name = "question")
    private String question;

    @Column(name="code_snippet")
    private String codeSnippet;

    @ManyToOne
    private Lesson Lesson;

    public Question(Long id) {
        Id = id;
    }

    public Question(Long id, String question, String codeSnippet, Long lessonId) {
        Id = id;
        this.question = question;
        this.codeSnippet = codeSnippet;
        this.Lesson = new Lesson(lessonId);
    }

    public Question() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Long getLesson() {
        return Lesson.getId();
    }

    public void setLesson(Long lessonId) {
        Lesson.setId(lessonId);
    }
}
