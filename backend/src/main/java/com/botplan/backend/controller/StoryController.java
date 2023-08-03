package com.botplan.backend.controller;


import com.botplan.backend.entity.Story;
import com.botplan.backend.repository.StoryRepository;
import com.botplan.backend.services.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("stories")
@CrossOrigin(origins = "*")
public class StoryController {

    @Autowired
    private StoryService storyService;

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
