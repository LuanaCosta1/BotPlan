package com.botplan.backend.controller;

import com.botplan.backend.dto.StoryDTO;
import com.botplan.backend.entity.Story;
import com.botplan.backend.response.BaseResponse;
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
    public BaseResponse<StoryDTO> add(@RequestBody Story story) {
        StoryDTO savedStory = storyService.addStory(story);
        return BaseResponse.<StoryDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(savedStory)
                .build();
    }

    @GetMapping("/")
    public BaseResponse<List<StoryDTO>> selectAll() {
        List<StoryDTO> allStories = storyService.getAllStories();
        return BaseResponse.<List<StoryDTO>>builder()
                .httpCode(200)
                .message("OK")
                .response(allStories)
                .build();
    }

    @GetMapping("/{id}")
    public BaseResponse<StoryDTO> getStory(@PathVariable("id") Long id) {
        StoryDTO storyDTO = storyService.getStory(id);
        return BaseResponse.<StoryDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(storyDTO)
                .build();
    }

    @PutMapping("/{id}")
    public BaseResponse<StoryDTO> update(@RequestBody Story story, @PathVariable("id") Long id){
        return BaseResponse.<StoryDTO>builder()
                .httpCode(200)
                .message("OK")
                .response(storyService.updateStory(story, id)).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        storyService.deleteStory(id);
    }
}
