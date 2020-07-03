package uk.ac.qub.njoy.dissertation.language;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "language")
    private String language;

    @Column(nullable = false, name="img_path")
    private String imagePath;

    @Column(nullable = false, name="icon_path")
    private String iconPath;

    public Language() {
    }

    public Language(Long id) {
        this.id = id;
    }

    public Language(Long id, String language, String imagePath, String iconPath) {
        this.id = id;
        this.language = language;
        this.imagePath = imagePath;
        this.iconPath = iconPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
}
