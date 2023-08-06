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

    public StoryDTO getStory(Long id) {return StoryMapper.toDto(storyRepository.findByIdTask(id));
    }
    public StoryDTO addStory(Story story){
        return StoryMapper.toDto(storyRepository.save(story));
    }

    public List<StoryDTO> getAllStories(){
        return storyRepository.findAll().stream()
                .map(StoryMapper::toDto)
                .collect(Collectors.toList());
    }

    public StoryDTO updateStory(Story story, Long idTask){
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
        return StoryMapper.toDto(storyRepository.save(entity));
    }

    public void deleteStory(Long idTask) {
        Story entity = storyRepository.findByIdTask(idTask);
        storyRepository.delete(entity);
    }
}
