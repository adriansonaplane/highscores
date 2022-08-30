package dev.ledesma.entities;


import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "account")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "initials")
    private String initials;
    @Column(name = "points")
    private int points;

    public Account() {
    }

    public Account(int id, String initials, int points) {
        this.id = id;
        this.initials = initials;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", initials=" + initials +
                ", points=" + points +
                '}';
    }
}
