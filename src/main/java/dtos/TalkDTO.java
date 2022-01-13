package dtos;

import entities.Talk;

import java.util.ArrayList;
import java.util.List;

public class TalkDTO {

    private long id;
    private String topic;
    private String duration;


    public TalkDTO(Talk talk){
        this.id = talk.getId();
        this.topic = talk.getTopic();
        this.duration = talk.getDuration();
    }


    public static List<TalkDTO> getDtos(List<Talk> talkList){
        List<TalkDTO> talkDTOList = new ArrayList<>();
        talkList.forEach(t -> talkDTOList.add(new TalkDTO(t)));
        return talkDTOList;


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
}
