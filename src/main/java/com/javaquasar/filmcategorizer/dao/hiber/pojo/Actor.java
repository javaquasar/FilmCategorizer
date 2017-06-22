package com.javaquasar.filmcategorizer.dao.hiber.pojo;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Java Quasar
 */
@Entity
@Table(name = "actor")
public class Actor extends Model {
    
    @Column(name = "name")
    private String name;
    @Column(name = "abbr")
    private String abbr;
    @ManyToOne
    private Sex sex;
    @Column(name = "birthday")
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;
    @Column(name = "rating")
    private int rating;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Nationality nationality;
    @ManyToOne
    private HairColor hairColor;
    @ManyToOne
    private FigureType figureType;
    @ManyToMany(mappedBy = "actors")
    private Set<Photo> photos;
    @Column(name = "photo_icon")
    private byte[] photoIcon;
    @Column(name = "photo_front")
    private byte[] photoFront;
    @Column(name = "photo_back")
    private byte[] photoBack;
    @ManyToMany(mappedBy = "actors")
    private Set<Film> films;

    public Actor() {
    }

    public Actor(Long id) {
        super(id);
    }

    public Actor(String name, 
            String abbr, 
            Sex sex, 
            int rating,
            Date birthday, 
            Country country, 
            Nationality nationality, 
            HairColor hairColor,
            FigureType figureType) {
        this.name = name;
        this.abbr = abbr;
        this.sex = sex;
        this.rating = rating;
        this.birthday = birthday;
        this.country = country;
        this.nationality = nationality;
        this.hairColor = hairColor;
        this.figureType = figureType;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public byte[] getPhotoIcon() {
        return photoIcon;
    }

    public void setPhotoIcon(byte[] photoIcon) {
        this.photoIcon = photoIcon;
    }

    public byte[] getPhotoFront() {
        return photoFront;
    }

    public void setPhotoFront(byte[] photoFront) {
        this.photoFront = photoFront;
    }

    public byte[] getPhotoBack() {
        return photoBack;
    }

    public void setPhotoBack(byte[] photoBack) {
        this.photoBack = photoBack;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

}
