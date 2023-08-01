package com.botplan.backend.services;

import com.botplan.backend.entity.Story;
import com.botplan.backend.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public Story addStory(Story story){
        return storyRepository.save(story);
    }

    public List<Story> getAllStories(){
        return storyRepository.findAll();
    }

    public Story updateStory(Story story, Long idTask){
        Story entity = storyRepository.findByIdTask(idTask);
        entity.setTitle(story.getTitle());
        entity.setDescription(story.getDescription());
        entity.setNotes(story.getNotes());
        entity.setNotes(String.valueOf(story.getPoints()));
        entity.setState(story.getState());
        entity.setPriority(story.getPriority());
        entity.setType(story.getType());
        entity.setTesterAssigned(story.getTesterAssigned());
        entity.setCreator(story.getCreator());
        entity.setCreationDate(story.getCreationDate());
        entity.setConclusionDate(story.getConclusionDate());
        entity.setIdEmployee(story.getIdEmployee());
        entity.setBackupIdEmployee(story.getBackupIdEmployee());
        return storyRepository.save(entity);
    }

    public void deleteStory(Long idTask) {
        Story entity = storyRepository.findByIdTask(idTask);
        storyRepository.delete(entity);
    }
}
