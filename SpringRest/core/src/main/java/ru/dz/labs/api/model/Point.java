package ru.dz.labs.api.model;

import javax.persistence.*;

/**
 * Created by Nikita Prozorov on 15.05.2016.
 */
@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float lat;

    private Float lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Point(Float lat, Float lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Point() {
    }
}
