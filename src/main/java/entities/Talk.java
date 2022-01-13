package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Talk {


    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private String Topic;
    private String Duration;


    @OneToMany
    private List<Prop> Props;

    public Talk() {
    }
}
