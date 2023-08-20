package com.botplan.backend.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) // Add this line
public class SprintStoriesDTO extends SprintDTO {
    private List<StoryDTO> stories;
}
