package dtos;

import entities.Conference;

import java.util.ArrayList;
import java.util.List;

public class ConferenceDTO {

    private long id;
    private String name;
    private String location;
    private String capacity;
    private String date;
    private String time;

    public ConferenceDTO(Conference c){
        this.id = c.getId();
        this.name = c.getName();
        this.location = c.getLocation();
        this.capacity = c.getCapacity();
        this.date = c.getDate();
        this.time = c.getTime();


    }


    public static List<ConferenceDTO> getDtos(List<Conference> conferenceList) {
        List<ConferenceDTO> conferenceDTOList = new ArrayList<>();
        conferenceList.forEach(c -> conferenceDTOList.add(new ConferenceDTO(c)));
        return conferenceDTOList;


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
