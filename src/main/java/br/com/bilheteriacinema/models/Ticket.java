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

    private Date sessionDate;

    private Double price;

    public Ticket() {}

    public Ticket(Film film, User user, Date sessionDate, Double price) {
        this.film = film;
        this.user = user;
        this.sessionDate = sessionDate;
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

    public Date getsessionDate() {
        return sessionDate;
    }

    public void setsessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
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
                ", sessionDate= " + sessionDate +
                ", price= " + price +
                '}';
    }
}
