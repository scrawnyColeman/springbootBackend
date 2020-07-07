package uk.ac.qub.njoy.dissertation.recommendation;

import uk.ac.qub.njoy.dissertation.lesson.Lesson;

import javax.persistence.*;

@Entity
@Table(name = "recommended_prerequisites")
public class Recommendation {

    @Id
    private Long id;

    @Column(name = "recommendation")
    private String name;

    @ManyToOne
    private Lesson lesson;

    public Recommendation(Long id) {
        this.id = id;
    }

    public Recommendation() {

    }

    public Recommendation(Long id, String name, Lesson lesson) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
