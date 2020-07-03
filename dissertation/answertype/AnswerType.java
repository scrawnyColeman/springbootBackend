package uk.ac.qub.njoy.dissertation.answertype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer_types")
public class AnswerType {
    @Id
    private Long id;

    @Column(nullable = false, name = "type_name")
    private String typeName;

    public AnswerType(Long id) {
        this.id = id;
    }

    public AnswerType(Long id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public AnswerType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
