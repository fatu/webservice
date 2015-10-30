package com.olol.spring.web.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author fatu
 */
@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 5, max = 255, groups = {PersistenceValidationGroup.class, FormValidationGroup.class})
    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Offer() {
        this.user = new User();
    }

    public Offer(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Offer(int id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Offer offer = (Offer) o;

        if (text != null ? !text.equals(offer.text) : offer.text != null) return false;
        return !(user != null ? !user.equals(offer.user) : offer.user != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                '}';
    }
}