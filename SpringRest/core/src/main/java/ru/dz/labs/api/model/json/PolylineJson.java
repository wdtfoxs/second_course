package ru.dz.labs.api.model.json;

/**
 * Created by Nikita Prozorov on 22.05.2016.
 */
public class PolylineJson {

    private Long event_id;
    private Float lat;
    private Float lng;
    private Long user_id;

    public Long getEvent_id() {
        return event_id;
    }

    public Float getLat() {
        return lat;
    }

    public Float getLng() {
        return lng;
    }

    public Long getUser_id() {
        return user_id;
    }
}
