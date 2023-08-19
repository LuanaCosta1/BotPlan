package com.botplan.backend.services;

import com.botplan.backend.dto.StoryDTO;
import com.botplan.backend.entity.Story;
import com.botplan.backend.mapper.StoryMapper;
import com.botplan.backend.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;

    public StoryDTO getStory(Long id) { return StoryMapper.toDto(storyRepository.findStoryById(id));
    }

    public StoryDTO addStory(Story story){
        return StoryMapper.toDto(storyRepository.save(story));
    }

    public List<StoryDTO> getAllStories(){
        return storyRepository.findAll().stream()
                .map(StoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public StoryDTO updateStory(Story story, Long id){
        Story entity = storyRepository.findStoryById(id);
        entity.setTitle(story.getTitle());
        entity.setDescription(story.getDescription());
        entity.setNotes(story.getNotes());
        entity.setPoints(story.getPoints());
        entity.setPriority(story.getPriority());
        entity.setType(story.getType());
        entity.setCreator(story.getCreator());
        entity.setCreationDate(story.getCreationDate());
        entity.setState(story.getState());
        entity.setTesterAssigned(story.getTesterAssigned());
        entity.setConclusionDate(story.getConclusionDate());
        entity.setEmployee(story.getEmployee());
        entity.setBackupEmployee(story.getBackupEmployee());
        return StoryMapper.toDto(storyRepository.save(entity));
    }

    public void deleteStory(Long id) {
        Story entity = storyRepository.findStoryById(id);
        storyRepository.delete(entity);
    }

}
