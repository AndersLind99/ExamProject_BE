package entities;

import dtos.TalkDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Talk implements Serializable {


    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String topic;
    private String duration;


    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Prop> Props;

    public Talk() {
    }

    public Talk(String topic, String duration) {
        this.topic = topic;
        this.duration = duration;
    }

    public Talk(TalkDTO talkDTO){
        this.topic = talkDTO.getTopic();
        this.duration = talkDTO.getDuration();


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Prop> getProps() {
        return Props;
    }

    public void setProps(List<Prop> props) {
        Props = props;
    }
}
