package uk.ac.qub.njoy.dissertation.lesson;

import uk.ac.qub.njoy.dissertation.language.Language;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = false, name = "theory")
    private String theory;

    @Column(nullable = false, name = "yt_link")
    private String youtubeLink;

    @ManyToOne
    private Language Language;

    @JoinTable(name = "recommended_prerequisites", joinColumns = {
            @JoinColumn(name = "lesson_id", referencedColumnName = "id", nullable =   false)}, inverseJoinColumns = {
            @JoinColumn(name = "recommended_lesson_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<Lesson> recommendedLessons;



    public Lesson(Long id, String title, String description, String theory, String youtubeLink, Long languageId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.theory = theory;
        this.youtubeLink = youtubeLink;
        this.Language = new Language(languageId);
    }

    public Lesson(Long id) {
        this.id = id;
    }

    public Lesson() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public uk.ac.qub.njoy.dissertation.language.Language getLanguage() {
        return Language;
    }

    public void setLanguage(uk.ac.qub.njoy.dissertation.language.Language language) {
        Language = language;
    }

    public Set<Lesson> getRecommendedLessons() {
        return recommendedLessons;
    }

    public void setRecommendedLessons(Set<Lesson> recommendedLessons) {
        this.recommendedLessons = recommendedLessons;
    }

}
