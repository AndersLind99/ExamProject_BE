package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Prop {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String prop;

    public Prop() {
    }



    // getters & setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
