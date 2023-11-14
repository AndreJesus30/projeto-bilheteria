package br.com.bilheteriacinema.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TShortFilm")
public class ShortFilm extends Film {

    private String director;

    @ElementCollection
    @CollectionTable(name = "ShortFilm_Genders")
    @Column(name = "gender")
    private List<String> gendersList;
    private int ageRating;

    public ShortFilm() {}
    public ShortFilm(Integer code, String title, Integer duration, String director, List<String> gendersList, int ageRating) {
        super(code, title, duration);
        this.director = director;
        this.gendersList = gendersList;
        this.ageRating = ageRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getGendersList() {
        return gendersList;
    }

    public void setGendersList(List<String> gender) {
        this.gendersList = gender;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                "director= " + director + '\'' +
                ", gendersList= " + gendersList +
                ", ageRating= " + ageRating +
                '}';
    }
}
