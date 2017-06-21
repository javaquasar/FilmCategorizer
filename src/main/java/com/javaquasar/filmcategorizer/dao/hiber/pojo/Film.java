package com.javaquasar.filmcategorizer.dao.hiber.pojo;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Java Quasar
 */
@Entity
@Table(name = "film")
public class Film extends Model {

    @Column(name = "name")
    private String name;
    @Column(name = "abbr")
    private String abbr;
    @Column(name = "rating")
    private int rating;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = {
                @JoinColumn(name = "film_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "actor_id")})
    private Set<Actor> actors;
    @ManyToMany
    @JoinTable(name = "film_studio",
            joinColumns = {
                @JoinColumn(name = "film_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "studio_id")})
    private Set<Studio> studios;
    @ManyToMany
    @JoinTable(name = "film_processType",
            joinColumns = {
                @JoinColumn(name = "film_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "processType_id")})
    private Set<ProcessType> processTypes;

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Studio> getStudios() {
        return studios;
    }

    public void setStudios(Set<Studio> studios) {
        this.studios = studios;
    }

    public Set<ProcessType> getProcessTypes() {
        return processTypes;
    }

    public void setProcessTypes(Set<ProcessType> processTypes) {
        this.processTypes = processTypes;
    }

}
