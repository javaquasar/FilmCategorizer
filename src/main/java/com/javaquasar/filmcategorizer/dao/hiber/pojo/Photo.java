package com.javaquasar.filmcategorizer.dao.hiber.pojo;

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
@Table(name = "photo")
public class Photo extends Model {
    
    @ManyToOne
    private PhotoType photoType;
    @Column(name = "data")
    private byte[] data;
    @ManyToMany
    @JoinTable(name = "photo_actor",
            joinColumns = {
                @JoinColumn(name = "actor_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "photo_id")})
    private Set<Actor> actors;

    public Photo() {
    }

    public PhotoType getPhotoType() {
        return photoType;
    }

    public void setPhotoType(PhotoType photoType) {
        this.photoType = photoType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
    
}
