package facades;

import dtos.ConferenceDTO;
import dtos.SpeakerDTO;
import dtos.TalkDTO;
import entities.Speaker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class SpeakerFacade {


    public SpeakerFacade() {
    }

    private static SpeakerFacade instance;
    private static EntityManagerFactory emf;

    public static SpeakerFacade getSpeakerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SpeakerFacade();
        }
        return instance;
    }

    public void createSpeaker(ConferenceDTO conferenceDTO){
        EntityManager em = emf.createEntityManager();


    }

    public List<SpeakerDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Speaker> query = em.createQuery("SELECT s FROM Speaker s", Speaker.class);
        List<Speaker> speakerList = query.getResultList();
        return SpeakerDTO.getDtos(speakerList);
    }

    public List<TalkDTO> getAllTalks(int id) {
        EntityManager em = emf.createEntityManager();
        Speaker Speaker = (em.find(Speaker.class, id));
        return TalkDTO.getDtos(Speaker.getTalks());


    }




}
