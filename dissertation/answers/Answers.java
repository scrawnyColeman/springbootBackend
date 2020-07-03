package uk.ac.qub.njoy.dissertation.answers;

import uk.ac.qub.njoy.dissertation.answertype.AnswerType;
import uk.ac.qub.njoy.dissertation.question.Question;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answers {

    @Id
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

    public Answers(Long id, String answer, Boolean isCorrect, String responseMessage, Long answerTypeId, Long questionId) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.responseMessage = responseMessage;
        answerType = new AnswerType(answerTypeId);
        question = new Question(questionId);
    }

    public Answers(Long id) {
        this.id = id;
    }

    public Answers() {
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

    public Long getAnswerTypeId() {
        return answerType.getId();
    }

    public void setAnswerType(Long answerTypeId) {
        answerType.setId(answerTypeId);
    }

    public Long getQuestionId() {
        return question.getId();
    }

    public void setQuestion(Long questionId) {
        question.setId(questionId);
    }
}
