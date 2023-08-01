package com.backend.BotPlan.controller;


import com.backend.BotPlan.entity.Story;
import com.backend.BotPlan.repository.StoryRepository;
import com.backend.BotPlan.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryService storyService;
    private StoryRepository storyRepository;

    @PostMapping("/")
    public Story add(@RequestBody Story story){
        return storyService.addStory(story);
    }

    @GetMapping("/")
    public List<Story> selectAll(){
        return storyService.getAllStories();
    }

    @PutMapping("/{idTask}")
    public Story update(@RequestBody Story story, @PathVariable("idTask") Long idTask){
        return storyService.updateStory(story, idTask);
    }

    @DeleteMapping("/{idTask}")
    public void delete(@PathVariable("idTask") long idTask){
        storyService.deleteStory(idTask);
    }
}
