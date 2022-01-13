package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Conference.deleteAllRows", query = "DELETE FROM Conference")
public class Conference {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String name;
    private String location;
    private String capacity;
    private String date;
    private String time;

    public Conference() {
    }

    public Conference(String name, String location, String capacity, String date, String time) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
        this.talkList = getTalkList();
    }


    @OneToMany
    private List<Talk> talkList;

    // getters & setters


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

    public List<Talk> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<Talk> talkList) {
        this.talkList = talkList;
    }
}
