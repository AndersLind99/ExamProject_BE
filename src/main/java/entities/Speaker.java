package entities;

import dtos.SpeakerDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Speaker implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String name;
    private String profession;
    private String gender;

    public Speaker() {
    }

    public Speaker(SpeakerDTO speakerDTO) {
        this.id = speakerDTO.getId();
        this.name = speakerDTO.getName();
        this.profession = speakerDTO.getProfession();
        this.gender = speakerDTO.getGender();
        this.talks = getTalks();

    }

    public Speaker( String name, String profession, String gender) {

        this.name = name;
        this.profession = profession;
        this.gender = gender;
        this.talks = getTalks();
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Talk> talks = new ArrayList<>();

    // getters & setters

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
        profession = profession;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Talk> getTalks() {
        return talks;
    }

    public void setTalks(List<Talk> talks) {
        this.talks = talks;
    }

    public void addTalk(Talk talk){

        this.talks.add(talk);
    }
}
