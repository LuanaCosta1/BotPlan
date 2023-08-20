package com.botplan.backend.services;

import com.botplan.backend.dto.SprintDTO;
import com.botplan.backend.entity.Sprint;
import com.botplan.backend.mapper.SprintMapper;
import com.botplan.backend.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public SprintDTO getSprint(Long id){
        return SprintMapper.toDto(sprintRepository.findBySprintId(id));
    }

    public SprintDTO addSprint(Sprint sprint){
        return SprintMapper.toDto(sprintRepository.save(sprint));
    }

    public List<SprintDTO> getAllSprints(){
        return sprintRepository.findAll().stream()
                .map(SprintMapper::toSprintStoriesDto)
                .collect(Collectors.toList());
    }

    public SprintDTO updateSprint(Sprint sprint, Long id){
        Sprint entity = sprintRepository.findBySprintId(id);
        sprint.setSprintId(entity.getSprintId());
        sprint.setStartDate(entity.getStartDate());
        sprint.setEndDate(entity.getEndDate());
        sprint.setGoal(entity.getGoal());
        sprint.setStories(entity.getStories());
        return SprintMapper.toDto(sprintRepository.save(entity));
    }

    public void deleteSprint(Long id) {
        Sprint entity = sprintRepository.findBySprintId(id);
        sprintRepository.delete(entity);
    }
}
