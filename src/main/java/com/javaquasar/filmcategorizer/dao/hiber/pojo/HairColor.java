package com.javaquasar.filmcategorizer.dao.hiber.pojo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Java Quasar
 */
@Entity
@Table(name = "hair_color")
public class HairColor extends Model {
    
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "hairColor")
    private List<Actor> actors;

    public HairColor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

}
