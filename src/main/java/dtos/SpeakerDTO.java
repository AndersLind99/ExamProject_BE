package dtos;

import entities.Conference;
import entities.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerDTO {

    private int id;
    private String name;
    private String profession;
    private String gender;


    public SpeakerDTO(Speaker speaker) {
        this.id = speaker.getId();
        this.name = speaker.getName();
        this.profession = speaker.getProfession();
        this.gender = speaker.getProfession();
    }

    public static List<SpeakerDTO> getDtos(List<Speaker> speakerList) {
        List<SpeakerDTO> speakerDTOList = new ArrayList<>();
        speakerList.forEach(s -> speakerDTOList.add(new SpeakerDTO(s)));
        return speakerDTOList;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
