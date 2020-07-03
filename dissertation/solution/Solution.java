package uk.ac.qub.njoy.dissertation.solution;

import uk.ac.qub.njoy.dissertation.practical.Practical;

import javax.persistence.*;

@Entity
@Table(name = "solutions")
public class Solution {

    @Id
    private Long id;

    @Column(name = "code_snippet")
    private String codeSnippet;

    @Column(name= "explanation")
    private String explanation;

    @OneToOne
    private Practical practical;

    public Solution(Long id, String codeSnippet, String explanation, Long practicalId) {
        this.id = id;
        this.codeSnippet = codeSnippet;
        this.explanation = explanation;
        practical = new Practical(practicalId);
    }

    public Solution(Long id) {
        this.id = id;
    }

    public Solution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getPracticalId() {
        return practical.getId();
    }

    public void setPracticalId(Long practicalId) {
        this.practical.setId(practicalId);
    }
}
