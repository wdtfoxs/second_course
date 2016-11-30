package ru.dz.labs.api.model.json;

/**
 * Created by Nikita Prozorov on 22.05.2016.
 */
public class PeopleInfoJson {
    private Long event_id;
    private String name;
    private Integer age;
    private Integer height;
    private String features;
    private String gender;

    public Long getEvent_id() {
        return event_id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public String getFeatures() {
        return features;
    }

    public String getGender() {
        return gender;
    }
}
