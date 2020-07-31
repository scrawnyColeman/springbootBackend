package uk.ac.qub.njoy.dissertation.answers;

import uk.ac.qub.njoy.dissertation.answertype.AnswerType;
import uk.ac.qub.njoy.dissertation.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "answer")
    private String answer;

    @Column(nullable = false, name = "is_correct")
    private Boolean isCorrect;

    @Column(nullable = false, name = "response_message")
    private String responseMessage;

    @ManyToOne
    private AnswerType answerType;

    @ManyToOne
    private Question question;

    public Answer(String answer, Boolean isCorrect, String responseMessage, Long answerTypeId, Long questionId) {
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.responseMessage = responseMessage;
        answerType = new AnswerType(answerTypeId);
        question = new Question(questionId);
    }

    public Answer(Long id) {
        this.id = id;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
