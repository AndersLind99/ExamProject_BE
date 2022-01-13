package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Talk {


    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String topic;
    private String duration;




    @OneToMany
    private List<Prop> Props;

    public Talk() {
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
