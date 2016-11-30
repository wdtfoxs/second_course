package ru.dz.labs.api.model.json;

/**
 * Created by Nikita Prozorov on 22.05.2016.
 */
public class FigurePointJson {

    private Long event_id;
    private Float lat;
    private Float lng;

    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
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
