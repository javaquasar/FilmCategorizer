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
@Table(name = "photo_type")
public class PhotoType extends Model {
    
    @Column(name = "name")
    private String name;
    @Column(name = "abbr")
    private String abbr;
    @OneToMany(mappedBy = "photoType")
    private List<Photo> photos;

    public PhotoType() {
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}