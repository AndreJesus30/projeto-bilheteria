package br.com.bilheteriacinema.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TTicket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date sessionData;

    private Double price;

    public Ticket() {}

    public Ticket(Film film, User user, Date sessionData, Double price) {
        this.film = film;
        this.user = user;
        this.sessionData = sessionData;
        this.price = price;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getSessionData() {
        return sessionData;
    }

    public void setSessionData(Date sessionData) {
        this.sessionData = sessionData;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ticket: " +
                "id= " + id +
                ", film= " + film +
                ", user= " + user +
                ", sessionData= " + sessionData +
                ", price= " + price +
                '}';
    }
}
