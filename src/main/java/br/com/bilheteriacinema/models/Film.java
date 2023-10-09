package br.com.bilheteriacinema.models;

import javax.persistence.*;

@Entity
@Table(name = "TFilm")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer code;
    private String title;
    private Integer duration;

    public Film() {}

    public Film(Integer code, String title, Integer duration) {
        this.code = code;
        this.title = title;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Film: " +
                "code= " + code +
                ", title= '" + title + '\'' +
                ", duration= " + duration + ", "
                ;
    }
}
