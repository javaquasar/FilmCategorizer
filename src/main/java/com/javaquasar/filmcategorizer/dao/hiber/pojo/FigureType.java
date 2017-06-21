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
@Table(name = "figure_type")
public class FigureType extends Model {
    
    @Column(name = "name")
    private String name;
    @Column(name = "abbr")
    private String abbr;
    @OneToMany(mappedBy = "figureType")
    private List<Actor> actors;

    public FigureType() {
    }

    public FigureType(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
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

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    
}

