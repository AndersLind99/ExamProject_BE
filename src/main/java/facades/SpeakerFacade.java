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

    public void createSpeaker(SpeakerDTO speakerDTO) {
        EntityManager em = emf.createEntityManager();
        Speaker speaker = new Speaker(speakerDTO);

        try {
            em.getTransaction().begin();
            em.persist(speaker);
            em.getTransaction().commit();

        } finally {
            em.close();
        }


    }

    public SpeakerDTO updateSpeaker(SpeakerDTO speakerDTO) {
        EntityManager em = emf.createEntityManager();
        Speaker speaker = em.find(Speaker.class, speakerDTO.getId());
        speaker.setName(speakerDTO.getName());
        speaker.setGender(speakerDTO.getGender());
        speaker.setProfession(speakerDTO.getProfession());

        try {
            em.getTransaction().begin();
            em.merge(speaker);
            em.getTransaction().commit();

        } finally {
            em.close();
        }


        return speakerDTO;
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
