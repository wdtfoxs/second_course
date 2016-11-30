package ru.dz.labs.api.model.json;

/**
 * Created by Nikita Prozorov on 22.05.2016.
 */
public class PointJson {

    private Long polyline_id;
    private Float lat;
    private Float lng;

    public Long getPolyline_id() {
        return polyline_id;
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
}
