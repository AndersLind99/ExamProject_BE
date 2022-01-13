package facades;

import dtos.ConferenceDTO;
import dtos.TalkDTO;
import entities.Conference;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConferenceFacade {

    public ConferenceFacade() {
    }

    private static ConferenceFacade instance;
    private static EntityManagerFactory emf;

    public static ConferenceFacade getConferenceFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ConferenceFacade();
        }
        return instance;
    }

    public void createConference(ConferenceDTO conferenceDTO){
        EntityManager em = emf.createEntityManager();


    }

    public List<ConferenceDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Conference> query = em.createQuery("SELECT c FROM Conference c", Conference.class);
        List<Conference> conferenceList = query.getResultList();
        return ConferenceDTO.getDtos(conferenceList);
    }

    public List<TalkDTO> getAllTalks(int id) {
        EntityManager em = emf.createEntityManager();
        Conference conference = (em.find(Conference.class, (long) id));
        return TalkDTO.getDtos(conference.getTalkList());


    }


}






